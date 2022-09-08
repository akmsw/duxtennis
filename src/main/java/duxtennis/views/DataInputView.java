package duxtennis.views;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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

  private static final int SLIDER_INI = 50;
  private static final int SLIDER_MIN = 0;
  private static final int SLIDER_MAX = 100;
  private static final int SLIDER_SPACING_MAJOR = 25;
  private static final int SLIDER_SPACING_MINOR = 5;

  private static final String FRAME_TITLE = "Ingreso de parámetros";
  private static final String GROWX = "growx";
  private static final String GROWX_SPAN = "growx, span";

  // ---------------------------------------- Private fields ------------------------------------

  private JButton continueButton;

  private JPanel masterPanel;

  private JSlider player1Slider;
  private JSlider player2Slider;

  private JTextField player1TextField;
  private JTextField player2TextField;
  private JTextField tournamentTextField;

  // ---------------------------------------- Constructor ---------------------------------------

  /**
   * Builds the names input view.
   */
  public DataInputView() {
    initializeInterface();
  }

  // ---------------------------------------- Public methods -------------------------------------

  // ---------------------------------------- Getters -------------------------------------------

  /**
   * Gets the 'continue' button.
   *
   * @return The 'continue' button.
   */
  public JButton getContinueButton() {
    return continueButton;
  }

  /**
   * Gets the player 1 skill slider.
   *
   * @return The player 1 skill slider.
   */
  public JSlider getPlayer1Slider() {
    return player1Slider;
  }

  /**
   * Gets the player 2 skill slider.
   *
   * @return The player 2 skill slider.
   */
  public JSlider getPlayer2Slider() {
    return player2Slider;
  }

  /**
   * Gets the player 1 name text field.
   *
   * @return The player 1 name text field.
   */
  public JTextField getPlayer1TextField() {
    return player1TextField;
  }

  /**
   * Gets the player 2 name text field.
   *
   * @return The player 2 name text field.
   */
  public JTextField getPlayer2TextField() {
    return player2TextField;
  }

    /**
   * Gets the tournament title text field.
   *
   * @return The tournament title text field.
   */
  public JTextField getTournamentTextField() {
    return tournamentTextField;
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
    addSliders();
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

    continueButton = new JButton("Continuar");
    continueButton.setEnabled(false);

    backButton.addActionListener(e ->
        ((DataInputController) Main.getController(Views.DATA_INPUT)).backButtonEvent()
    );

    masterPanel.add(continueButton, GROWX_SPAN);
    masterPanel.add(backButton, GROWX_SPAN);
  }

  // ---------------------------------------- Private methods -----------------------------------

  /**
   * Creates and places the parameters input text fields.
   */
  private void addTextFields() {
    JLabel player1Label = new JLabel("Nombre del jugador #1:");
    JLabel player2Label = new JLabel("Nombre del jugador #2:");
    JLabel tournamentLabel = new JLabel("Nombre del torneo:");

    player1TextField = new JTextField(Main.MAX_NAME_LEN);
    player2TextField = new JTextField(Main.MAX_NAME_LEN);
    tournamentTextField = new JTextField(Main.MAX_NAME_LEN);

    masterPanel.add(tournamentLabel);
    masterPanel.add(tournamentTextField, GROWX);

    masterPanel.add(new JSeparator(), GROWX_SPAN);

    masterPanel.add(player1Label);
    masterPanel.add(player1TextField, GROWX);
    masterPanel.add(player2Label);
    masterPanel.add(player2TextField, GROWX);

    masterPanel.add(new JSeparator(), GROWX_SPAN);
  }

  /**
   * Creates and places the parameters input sliders.
   */
  private void addSliders() {
    JLabel player1SliderLabel = new JLabel("Probabilidad de que gane el jugador #1");
    JLabel player2SliderLabel = new JLabel("Probabilidad de que gane el jugador #2");

    player1Slider = new JSlider(SwingConstants.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INI);
    player2Slider = new JSlider(SwingConstants.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INI);

    player1Slider.setMajorTickSpacing(SLIDER_SPACING_MAJOR);
    player1Slider.setMinorTickSpacing(SLIDER_SPACING_MINOR);
    player1Slider.setPaintTicks(true);
    player1Slider.setPaintLabels(true);

    player2Slider.setMajorTickSpacing(SLIDER_SPACING_MAJOR);
    player2Slider.setMinorTickSpacing(SLIDER_SPACING_MINOR);
    player2Slider.setPaintTicks(true);
    player2Slider.setPaintLabels(true);

    masterPanel.add(player1SliderLabel, GROWX_SPAN);
    masterPanel.add(player1Slider, GROWX_SPAN);

    masterPanel.add(new JSeparator(), GROWX_SPAN);

    masterPanel.add(player2SliderLabel, GROWX_SPAN);
    masterPanel.add(player2Slider, GROWX_SPAN);

    addSlidersChangeListeners();
  }

  /**
   * Sets up the sliders change listeners.
   */
  private void addSlidersChangeListeners() {
    player1Slider.addChangeListener(e -> player2Slider.setValue(100 - player1Slider.getValue()));
    player2Slider.addChangeListener(e -> player1Slider.setValue(100 - player2Slider.getValue()));
  }
}