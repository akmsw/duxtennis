package duxtennis.views;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import duxtennis.Main;
import duxtennis.controllers.DataInputController;
import duxtennis.models.Views;
import net.miginfocom.swing.MigLayout;

/**
 * Data input view class.
 *
 * @author Bonino, Francisco Ignacio.
 * @version 0.0.1
 * @since 08/09/2022
 */
public class DataInputView extends View {

  // ---------------------------------------- Private constants ---------------------------------

  private static final String FRAME_TITLE = "Ingreso de parámetros";
  private static final String GROWX = "growx";

  // ---------------------------------------- Private fields ------------------------------------

  private JPanel masterPanel;

  private JTextField player1TextField;
  private JTextField player2TextField;

  // ---------------------------------------- Constructor ---------------------------------------

  /**
   * Builds the names input view.
   */
  public DataInputView() {
    initializeInterface();
  }

  // ---------------------------------------- Protected methods ---------------------------------

  /**
   * Initializes the view and makes it visible.
   */
  @Override
  protected void initializeInterface() {
    masterPanel = new JPanel(new MigLayout("wrap 2"));

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setTitle(FRAME_TITLE);
    setResizable(false);
    addTextFields();
    addButtons();
    add(masterPanel);
    pack();
    setLocationRelativeTo(null);
  }

  /**
   * Adds the buttons to their corresponding panel.
   */
  @Override
  protected void addButtons() {
    JButton backButton = new JButton("Atrás");

    backButton.addActionListener(e ->
        ((DataInputController) Main.getController(Views.DATA_INPUT)).backButtonEvent()
    );

    masterPanel.add(backButton, "growx, span");
  }

  // ---------------------------------------- Private methods -----------------------------------

  /**
   * 
   */
  private void addTextFields() {
    JLabel player1Label = new JLabel("Nombre del jugador #1:");
    JLabel player2Label = new JLabel("Nombre del jugador #2:");

    player1TextField = new JTextField(Main.MAX_NAME_LEN);
    player2TextField = new JTextField(Main.MAX_NAME_LEN);

    masterPanel.add(player1Label);
    masterPanel.add(player1TextField, GROWX);
    masterPanel.add(player2Label);
    masterPanel.add(player2TextField, GROWX);
  }
}