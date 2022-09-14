package duxtennis.views;

import duxtennis.Main;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import net.miginfocom.swing.MigLayout;

/**
 * Current match view class.
 *
 * @author Bonino, Francisco Ignacio.
 * @version 0.0.1
 * @since 08/09/2022
 */
public class CurrentMatchView extends View {

  // ---------------------------------------- Private constants ---------------------------------

  private static final int TABLE_COLUMNS = 5;
  private static final int TABLE_ROWS = 3;

  private static final String FRAME_TITLE = "Progreso del partido";

  private static final String[] TABLE_TITLES = {
    "SAQUE", "SETS", "GAMES", "PUNTOS"
  };

  // ---------------------------------------- Private fields ------------------------------------

  private JLabel tournamentNameLabel;

  private JPanel panel;

  private JTable table;

  // ---------------------------------------- Constructor ---------------------------------------

  /**
   * Builds the current match progression view.
   */
  public CurrentMatchView() {
    initializeInterface();
  }

  // ---------------------------------------- Public methods ------------------------------------

  /**
   * Initializes the view and makes it visible.
   */
  @Override
  public void initializeInterface() {
    panel = new JPanel(new MigLayout("wrap"));

    addTable();
    addLabel();
    add(panel);
    setResizable(false);
    setTitle(FRAME_TITLE);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setIconImage(Main.ICON
                     .getImage());
  }

  // --------------------------------------------- Getters --------------------------------------

  /**
   * Gets the tournament name label.
   *
   * @return The tournament name label.
   */
  public JLabel getTournamentNameLabel() {
    return tournamentNameLabel;
  }

  /**
   * Gets the results table.
   *
   * @return The results table.
   */
  public JTable getTable() {
    return table;
  }

  // ---------------------------------------- Protected methods ---------------------------------

  /**
   * Adds the buttons to the panel.
   */
  @Override
  protected void addButtons() {
    // No body needed
  }

  // ---------------------------------------- Private methods -----------------------------------

  /**
   * Adds the current match results table to the panel.
   */
  private void addTable() {
    tournamentNameLabel = new JLabel();

    tournamentNameLabel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
    tournamentNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
    tournamentNameLabel.setBackground(Main.LIGHT_GREEN);
    tournamentNameLabel.setOpaque(true);

    panel.add(tournamentNameLabel, "growx, span");

    table = new JTable(TABLE_ROWS, TABLE_COLUMNS);

    setTableFormat();
    fillTableFields();

    panel.add(table, "push, grow, span, center");
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

            if (row == 0 || column == 0) {
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
   * Fills the table cells whose texts do not change.
   */
  private void fillTableFields() {
    for (int i = 0; i < TABLE_TITLES.length; i++) {
      table.setValueAt(TABLE_TITLES[i], 0, i + 1);
    }
  }

  /**
   * Adds the informative label to the panel.
   */
  private void addLabel() {
    JLabel label = new JLabel("Partido en curso...");

    label.setBorder(BorderFactory.createLoweredSoftBevelBorder());
    label.setHorizontalAlignment(SwingConstants.CENTER);
    label.setBackground(Main.LIGHT_GREEN);
    label.setOpaque(true);

    panel.add(label, "growx, span");
  }
}