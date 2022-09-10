package duxtennis.views;

import duxtennis.Main;
import duxtennis.controllers.MatchResultController;
import duxtennis.models.Set;
import duxtennis.models.Views;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import net.miginfocom.swing.MigLayout;

/**
 * Match result view class.
 *
 * @author Bonino, Francisco Ignacio.
 * @version 0.0.1
 * @since 09/09/2022
 */
public class MatchResultView extends View {

  private static final String FRAME_TITLE = "Resultado del partido";

  // ---------------------------------------- Private fields ------------------------------------

  private JLabel titleLabel;

  private JPanel panel;

  private JTable table;

  // ---------------------------------------- Constructor ---------------------------------------

  /**
   * Construye una ventana de resultados.
   */
  public MatchResultView() {
    // No body needed
  }

  // ---------------------------------------- Public methods ------------------------------------

  /**
   * Initializes the view and makes it visible.
   */
  @Override
  public void initializeInterface() {
    panel = new JPanel(new MigLayout("wrap"));

    addLabel();
    addTable();
    addButtons();
    add(panel);
    setResizable(false);
    setTitle(FRAME_TITLE);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setIconImage(Main.ICON.getImage());
  }

  /**
   * Gets the title label.
   *
   * @return The title label.
   */
  public JLabel getTitleLabel() {
    return titleLabel;
  }

  public JTable getTable() {
    return table;
  }

  // ---------------------------------------- Protected methods ---------------------------------

  /**
   * Adds the buttons to their corresponding panel.
   */
  @Override
  protected void addButtons() {
    JButton rematchButton = new JButton("Revancha");
    JButton mainMenuButton = new JButton("Volver al menú principal");

    rematchButton.addActionListener(e ->
        ((MatchResultController) Main.getController(Views.MATCH_RESULT)).rematchButtonEvent()
    );

    mainMenuButton.addActionListener(e ->
        ((MatchResultController) Main.getController(Views.MATCH_RESULT)).mainMenuButtonEvent()
    );

    panel.add(rematchButton, "growx");
    panel.add(mainMenuButton, "growx");
  }

  // ---------------------------------------- Private methods -----------------------------------

  /**
   * Adds the title label in the view panel.
   */
  private void addLabel() {
    titleLabel = new JLabel();

    titleLabel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
    titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    titleLabel.setBackground(Main.LIGHT_GREEN);
    titleLabel.setOpaque(true);

    panel.add(titleLabel, "growx, span");
  }

  /**
   * Adds the results table in the view panel.
   */
  private void addTable() {
    table = new JTable(2, Main.getMatch()
                              .getSetsAmount() + 1);

    setTableFormat();
    fillTable();

    panel.add(table, "growx, span");
  }

  /**
   * Sets the table cells format, including text alignment,
   * style and background color.
   */
  private void setTableFormat() {
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    table.setCellSelectionEnabled(false);
    table.setRowSelectionAllowed(false);
    table.setColumnSelectionAllowed(false);
    table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    table.setEnabled(false);
    table.setDefaultRenderer(
        Object.class,
        new DefaultTableCellRenderer() {
          /**
           * Configures the table cells background colors and text style & alignment.
           *
           * @param table      Source table.
           * @param value      Table cell value.
           * @param isSelected If the cell is selected.
           * @param hasFocus   If the cell is focused.
           * @param row        Cell row number.
           * @param column     Cell column number.
           */
          @Override
          public Component getTableCellRendererComponent(JTable myTable, Object value,
                                                         boolean isSelected, boolean hasFocus,
                                                         int row, int column) {
            final Component c = super.getTableCellRendererComponent(myTable, value, isSelected,
                                                                    hasFocus, row, column);

            if (column == 0) {
              c.setBackground(Main.LIGHT_BLUE);
              c.setFont(c.getFont()
                         .deriveFont(Font.BOLD));
            } else {
              c.setBackground(Main.DEFAULT_GRAY);
              c.setFont(c.getFont()
                         .deriveFont(Font.PLAIN));
            }

            ((DefaultTableCellRenderer) c).setHorizontalAlignment(SwingConstants.CENTER);

            return c;
          }
        }
    );

    for (int column = 0; column < table.getColumnCount(); column++) {
      table.getColumnModel()
           .getColumn(column)
           .setPreferredWidth(Main.TABLE_CELLS_WIDTH);
    }
  }

  /**
   * Fills the match result table with the sets results.
   */
  private void fillTable() {
    for (int i = 0; i < 2; i++) {
      table.setValueAt(Main.getMatch()
                           .getPlayers()
                           .get(i)
                           .getName(), i, 0);
    }

    for (int i = 0; i < Main.getMatch()
                            .getSetsAmount(); i++) {
      Set set = Main.getMatch()
                    .getFinishedSets()
                    .get(i);

      table.setValueAt(set.getLoserWonGames(), set.getLoserIndex(), i + 1);
      table.setValueAt(set.getWinnerWonGames(), set.getWinnerIndex(), i + 1);
    }
  }
}