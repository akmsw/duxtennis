package duxtennis.views;

import duxtennis.Main;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import net.miginfocom.swing.MigLayout;

/**
 * Match result view class.
 *
 * @author Bonino, Francisco Ignacio.
 * @version 0.0.1
 * @since 09/09/2022
 */
public class MatchResultView extends View {

  // ---------------------------------------- Private fields ------------------------------------

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

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setIconImage(Main.ICON.getImage());
    setResizable(false);
    setTitle("Resultado del partido");
    addTable();
    addButtons();
    add(panel);
  }

  // ---------------------------------------- Protected methods ---------------------------------

  /**
   * Adds the buttons to their corresponding panel.
   */
  @Override
  protected void addButtons() {
    JButton rematchButton = new JButton("Revancha");

    panel.add(rematchButton, "growx");
  }

  /**
   * Adds the results table in the view panel.
   */
  private void addTable() {

  }
}