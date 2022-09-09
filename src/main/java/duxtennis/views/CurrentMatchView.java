package duxtennis.views;

import duxtennis.Main;
import java.awt.Color;
import java.awt.Component;
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

  /**
   * Fixed table cells width (in pixels).
   * This value depends on the program's font
   * and the maximum player name length.
   */
  private static final int FIXED_CELL_WIDTH = 130;
  private static final int TABLE_COLUMNS = 5;
  private static final int TABLE_ROWS = 3;

  private static final String FRAME_TITLE = "Progreso del partido actual";

  private static final String[] TABLE_TITLES = {
    "SAQUE", "SETS", "GAMES", "PUNTOS"
  };

  // ---------------------------------------- Private fields ------------------------------------

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
    pack();
    setLocationRelativeTo(null);
  }

  // --------------------------------------------- Getters --------------------------------------

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
   * Adds the buttons to their corresponding panel.
   */
  @Override
  protected void addButtons() {
    // No body needed
  }

  // ---------------------------------------- Private methods -----------------------------------

  /**
   * Adds the current match results table in the view panel.
   */
  private void addTable() {
    table = new JTable(TABLE_ROWS, TABLE_COLUMNS);

    setTableFormat();
    fillTableFields();

    panel.add(table, "push, grow, span, center");
  }

  /**
   * Sets the table cells format, including text alignment
   * and background colors.
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
           * Configures the table cells background colors and text alignment.
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
              ((DefaultTableCellRenderer) c).setHorizontalAlignment(SwingConstants.CENTER);
            } else {
              c.setBackground(Main.DEFAULT_GRAY);
            }

            return c;
          }
        }
    );

    for (int column = 0; column < table.getColumnCount(); column++) {
      table.getColumnModel()
           .getColumn(column)
           .setPreferredWidth(FIXED_CELL_WIDTH);
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
   * Adds the informative label in the view panel.
   */
  private void addLabel() {
    JLabel label = new JLabel("Partido en curso...");

    label.setBorder(BorderFactory.createLoweredSoftBevelBorder());
    label.setHorizontalAlignment(SwingConstants.CENTER);

    panel.add(label, "growx, span");
  }
}