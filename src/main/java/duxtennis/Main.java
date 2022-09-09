package duxtennis;

import duxtennis.controllers.Controller;
import duxtennis.controllers.CurrentMatchController;
import duxtennis.controllers.DataInputController;
import duxtennis.controllers.MainMenuController;
import duxtennis.models.Match;
import duxtennis.models.Player;
import duxtennis.models.Views;
import duxtennis.utils.MatchSimulator;
import duxtennis.views.CurrentMatchView;
import duxtennis.views.DataInputView;
import duxtennis.views.MainMenuView;
import java.awt.Color;
import java.util.EnumMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Main class, only for program initialization and useful fields declaration.
 *
 * @author Bonino, Francisco Ignacio.
 * @version 0.0.1
 * @since 07/09/2022
 */
public final class Main {

  // ---------------------------------------- Private constants ---------------------------------

  private static final String ICON_FILENAME = "icon.png";
  private static final String ERROR_MESSAGE_TITLE = "¡Error!";

  // ---------------------------------------- Public constants ----------------------------------

  public static final int MAX_NAME_LEN = 10;

  public static final Color DEFAULT_GRAY = new Color(238, 238, 238);
  public static final Color LIGHT_BLUE = new Color(163, 184, 204);
  public static final Color LIGHT_GREEN = new Color(176, 189, 162);

  public static final String IMG_PATH = "img/";
  public static final String NAMES_VALIDATION_REGEX = "[a-z A-ZÁÉÍÓÚáéíóúñÑ]+";
  public static final String PROGRAM_TITLE = "DuxTennis";

  /**
   * Program icon.
   */
  public static final ImageIcon ICON = new ImageIcon(
      Main.class
          .getClassLoader()
          .getResource(Main.IMG_PATH + Main.ICON_FILENAME)
  );

  // ---------------------------------------- Private fields ------------------------------------

  private static Map<Views, Controller> controllersMap;

  private static Match match;

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
    setGraphicalProperties();
    setupMatch();
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
  * Triggers the match simulation.
  */
  public static void simulateMatch() {
    MatchSimulator matchSimulator = new MatchSimulator(Main.getMatch());

    matchSimulator.simulate();
  }

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

  /**
   * Gets the current match.
   *
   * @return The current match.
   */
  public static Match getMatch() {
    return match;
  }

  // ---------------------------------------- Private methods -----------------------------------

  // ---------------------------------------- Setters -------------------------------------------

  /**
   * Creates an empty match.
   */
  private static final void setupMatch() {
    match = new Match(new Player(""), new Player(""), "", 0);
  }

  /**
   * Sets the views controllers.
   */
  private static final void setControllers() {
    controllersMap = new EnumMap<>(Views.class);

    Controller mainMenuController = new MainMenuController(new MainMenuView());
    controllersMap.put(Views.MAIN_MENU, mainMenuController);

    Controller dataInputController = new DataInputController(new DataInputView());
    controllersMap.put(Views.DATA_INPUT, dataInputController);

    Controller currentMatchController = new CurrentMatchController(new CurrentMatchView());
    controllersMap.put(Views.CURRENT_MATCH, currentMatchController);
  }

  /**
   * Sets up the program's GUI properties.
   */
  private static final void setGraphicalProperties() {
    UIManager.put("Table.background", DEFAULT_GRAY);
    UIManager.put("ComboBox.background", Color.WHITE);
  }
}