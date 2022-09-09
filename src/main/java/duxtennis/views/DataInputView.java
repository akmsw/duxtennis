package duxtennis.views;

import duxtennis.Main;
import duxtennis.controllers.DataInputController;
import duxtennis.models.Views;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InvalidNameException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
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
  private static final String GROWX_SPAN = "growx, span";

  private static final String[] OPTIONS_COMBOBOX = {
    "Mejor de 3",
    "Mejor de 5"
  };

  // ---------------------------------------- Private fields ------------------------------------

  private JButton continueButton;

  private JComboBox<String> comboBox;

  private JPanel masterPanel;

  private List<JSlider> sliders;
  private List<JTextField> textFields;

  // ---------------------------------------- Constructor ---------------------------------------

  /**
   * Builds the data input view.
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
   * Gets the combobox.
   *
   * @return The combobox.
   */
  public JComboBox<String> getComboBox() {
    return comboBox;
  }

  /**
   * Gets a list containing the view's sliders.
   *
   * @return A list containing the view's sliders.
   */
  public List<JSlider> getSliders() {
    return sliders;
  }

  /**
   * Gets a list containing the view's text fields.
   *
   * @return A list containing the view's text fields.
   */
  public List<JTextField> getTextFields() {
    return textFields;
  }

  // ---------------------------------------- Protected methods ---------------------------------

  /**
   * Initializes the view and makes it visible.
   */
  @Override
  protected void initializeInterface() {
    masterPanel = new JPanel(new MigLayout("wrap 2"));

    addTextFields();
    addSliders();
    addComboBox();
    addButtons();
    add(masterPanel);
    setResizable(false);
    setTitle(FRAME_TITLE);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

    continueButton.addActionListener(e ->
        ((DataInputController) Main.getController(Views.DATA_INPUT)).continueButtonEvent()
    );

    masterPanel.add(continueButton, GROWX_SPAN);
    masterPanel.add(backButton, GROWX_SPAN);
  }

  // ---------------------------------------- Private methods -----------------------------------

  /**
   * Creates and places the parameters input text fields.
   */
  private void addTextFields() {
    textFields = new ArrayList<>();

    var wrapperIndex = new Object() {
      private int index;
    };

    for (wrapperIndex.index = 0; wrapperIndex.index < 3; wrapperIndex.index++) {
      JLabel label = new JLabel("Nombre del " + (wrapperIndex.index == 0
                                                 ? "torneo"
                                                 : "jugador #" + wrapperIndex.index));

      JTextField tf = new JTextField(Main.MAX_NAME_LEN);

      textFields.add(tf);

      tf.addActionListener(e -> {
        try {
          ((DataInputController) Main.getController(Views.DATA_INPUT))
          .textFieldEvent(tf.getText(), textFields.indexOf(tf));
        } catch (IllegalArgumentException stringEx) {
          Main.showErrorMessage("El nombre debe estar formado sólo por letras");

          tf.setText("");

          return;
        } catch (InvalidNameException nameEx) {
          Main.showErrorMessage("El nombre no puede estar vacío, "
                                + "tener más de " + Main.MAX_NAME_LEN
                                + " caracteres, o estar repetido");

          tf.setText("");

          return;
        } finally {
          continueButton.setEnabled(namesSetted());
        }
      });

      masterPanel.add(label);
      masterPanel.add(tf, GROWX);
    }
  }

  /**
   * Creates and places the parameters input sliders.
   */
  private void addSliders() {
    List<JLabel> skillLabels = new ArrayList<>();

    skillLabels.add(new JLabel());
    skillLabels.add(new JLabel());

    sliders = new ArrayList<>();

    for (int i = 0; i < 2; i++) {
      JSlider slider = new JSlider(SwingConstants.HORIZONTAL, DataInputController.SLIDER_MIN,
                                   DataInputController.SLIDER_MAX, DataInputController.SLIDER_INI);

      slider.setMajorTickSpacing(DataInputController.SLIDER_SPACING_MAJOR);
      slider.setMinorTickSpacing(DataInputController.SLIDER_SPACING_MINOR);
      slider.setPaintTicks(true);
      slider.setPaintLabels(true);

      JLabel label = new JLabel("Probabilidad de que gane el jugador #" + (i + 1) + ":");

      skillLabels.get(i)
                 .setText(slider.getValue() + "%");

      masterPanel.add(new JSeparator(), GROWX_SPAN);
      masterPanel.add(label);
      masterPanel.add(skillLabels.get(i));
      masterPanel.add(slider, GROWX_SPAN);

      sliders.add(slider);
    }

    sliders.get(0)
           .addChangeListener(e -> {
             sliders.get(1)
                    .setValue(100 - sliders.get(0)
                                           .getValue());

             skillLabels.get(0)
                        .setText(sliders.get(0)
                                        .getValue() + "%");
           });

    sliders.get(1)
           .addChangeListener(e -> {
             sliders.get(0)
                    .setValue(100 - sliders.get(1)
                                           .getValue());

             skillLabels.get(1)
                        .setText(sliders.get(1)
                                        .getValue() + "%");
           });
  }

  /**
   * Creates and places the game sets amount combobox.
   */
  private void addComboBox() {
    comboBox = new JComboBox<>(OPTIONS_COMBOBOX);

    comboBox.setSelectedIndex(0);

    JLabel setsAmountLabel = new JLabel("Cantidad de sets:");

    masterPanel.add(new JSeparator(), GROWX_SPAN);
    masterPanel.add(setsAmountLabel);
    masterPanel.add(comboBox, GROWX);
  }

  /**
   * Checks whether the tournament and the players names are setted.
   *
   * @return Whether the tournament and the players names are setted.
   */
  private boolean namesSetted() {
    return !Main.getMatch()
                .getTournamentName()
                .equals("")
           && Main.getMatch()
                  .getPlayers()
                  .stream()
                  .noneMatch(p -> p.getName()
                                   .equals(""));
  }
}