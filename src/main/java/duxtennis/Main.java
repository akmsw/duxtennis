package duxtennis;

import duxtennis.controllers.Controller;
import duxtennis.controllers.DataInputController;
import duxtennis.controllers.MainMenuController;
import duxtennis.models.Views;
import duxtennis.views.DataInputView;
import duxtennis.views.MainMenuView;
import java.util.EnumMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 * Main class, only for program initialization and useful fields declaration.
 *
 * @author Bonino, Francisco Ignacio.
 * @version 0.0.1
 * @since 07/09/2022
 */
public final class Main {

  // ---------------------------------------- Public constants ----------------------------------

  public static final int MAX_NAME_LEN = 10;

  public static final String IMG_PATH = "img/";
  public static final String NAMES_VALIDATION_REGEX = "[a-z A-ZÁÉÍÓÚáéíóúñÑ]+";
  public static final String PROGRAM_TITLE = "DuxTennis";

  // ---------------------------------------- Private constants ---------------------------------

  private static final String ERROR_MESSAGE_TITLE = "¡Error!";

  // ---------------------------------------- Private fields ------------------------------------

  private static Map<Views, Controller> controllersMap;

  // ---------------------------------------- Constructor ---------------------------------------

  /**
   * Empty constructor.
   */
  private Main() {
    // No body needed
  }

  // ---------------------------------------- Main entry point ----------------------------------

  /**
   * Runs the program.
   *
   * @param args Program arguments (not used yet).
   */
  public static void main(String[] args) {
    setControllers();

    ((MainMenuController) getController(Views.MAIN_MENU)).showView();
  }

  // ---------------------------------------- Public methods ------------------------------------

  /**
   * Builds an error window with a custom message.
   *
   * @param errorMessage Custom error message to show.
   */
  public static void showErrorMessage(String errorMessage) {
    JOptionPane.showMessageDialog(null, errorMessage, ERROR_MESSAGE_TITLE,
                                  JOptionPane.ERROR_MESSAGE, null);
  }

  // ---------------------------------------- Getters -------------------------------------------

  /**
   * Gets the corresponding controller to the requested view.
   *
   * @param view The view whose controller is needed.
   *
   * @return The requested view's controller.
  */
  public static Controller getController(Views view) {
    return controllersMap.get(view);
  }

  // ---------------------------------------- Setters -------------------------------------------

  private static final void setControllers() {
    controllersMap = new EnumMap<>(Views.class);

    Controller mainMenuController = new MainMenuController(new MainMenuView());
    controllersMap.put(Views.MAIN_MENU, mainMenuController);

    Controller dataInputController = new DataInputController(new DataInputView());
    controllersMap.put(Views.DATA_INPUT, dataInputController);
  }
}