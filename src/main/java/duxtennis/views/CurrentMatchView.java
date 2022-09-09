package duxtennis.views;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.WindowConstants;
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

  private static final String FRAME_TITLE = "Progreso del partido actual";

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
    table = new JTable(3, 5);

    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    table.setCellSelectionEnabled(false);
    table.setRowSelectionAllowed(false);
    table.setColumnSelectionAllowed(false);
    table.setEnabled(false);

    setTableFields();

    panel.add(table, "push, grow, span, center");
  }

  private void setTableFields() {
    table.setValueAt("SAQUE", 0, 1);
    table.setValueAt("PEPE", 1, 0);
    table.setValueAt("JULIO", 2, 0);
  }
}