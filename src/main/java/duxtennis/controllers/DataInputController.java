package duxtennis.controllers;

import duxtennis.Main;
import duxtennis.models.Views;
import duxtennis.views.DataInputView;
import java.util.regex.Pattern;
import javax.naming.InvalidNameException;

/**
 * Data input view controller class.
 *
 * @author Bonino, Francisco Ignacio.
 * @version 0.0.1
 * @since 08/09/2022
 */
public class DataInputController extends Controller {

  // ---------------------------------------- Public constants ----------------------------------

  public static final int SLIDER_INI = 50;
  public static final int SLIDER_MIN = 0;
  public static final int SLIDER_MAX = 100;
  public static final int SLIDER_SPACING_MAJOR = 25;
  public static final int SLIDER_SPACING_MINOR = 5;

  // ---------------------------------------- Constructor ---------------------------------------

  /**
   * Builds the data input view controller.
   *
   * @param dataInputView View to control.
   */
  public DataInputController(DataInputView dataInputView) {
    super(dataInputView);
  }

  // ---------------------------------------- Public methods ------------------------------------

  /**
   * Makes the controlled view invisible and resets it to its default values.
   */
  @Override
  public void resetView() {
    hideView();

    ((DataInputView) getView()).getSliders()
                               .get(0)
                               .setValue(SLIDER_INI);

    ((DataInputView) getView()).getTextFields()
                               .forEach(tf -> tf.setText(""));

    ((DataInputView) getView()).getComboBox()
                               .setSelectedIndex(0);

    ((DataInputView) getView()).getContinueButton()
                               .setEnabled(false);
  }

  /**
   * 'Back' button event handler.
   *
   * <p>Resets the controlled view to its default values,
   * and shows the main menu view.
   */
  public void backButtonEvent() {
    resetView();
    clearNames();

    Main.getController(Views.MAIN_MENU)
        .showView();
  }

  /**
   * Text fields input event handler.
   *
   * <p>Validates the user input with a regular expression that checks if the string
   * contains only latin characters from A to Z including Ñ, uppercase or lowercase,
   * with or without accent mark, with or without spaces.
   * If the input is not valid or already exists, the program asks for a new input.
   *
   * <p>If the input is valid, it will be applied as a player name or as the tournament name.
   *
   * @param text The user input in the text field.
   *
   * @throws IllegalArgumentException When the input is an invalid string.
   * @throws InvalidNameException     When the input is an invalid name.
   */
  public void textFieldEvent(String text, int tfIndex)
                            throws IllegalArgumentException, InvalidNameException {
    if (!validString(text)) {
      throw new IllegalArgumentException();
    }

    text = text.trim()
               .toUpperCase();

    if (tfIndex == 0) {
      Main.getMatch()
          .setTournamentName(text);

      return;
    }

    if (!validName(text)) {
      throw new InvalidNameException();
    }

    Main.getMatch()
        .getPlayers()
        .get(tfIndex - 1)
        .setName(text);
  }

  /**
   * Makes the current view invisible, retrieves and applies
   * the players skill points from the sliders, updates the
   * match match sets amount and makes the next view visible.
   */
  public void continueButtonEvent() {
    hideView();

    for (int i = 0; i < 2; i++) {
      Main.getMatch()
          .getPlayers()
          .get(i)
          .setSkillPoints(((DataInputView) getView()).getSliders()
                                                     .get(i)
                                                     .getValue());
    }

    Main.getMatch()
        .setMatchSetsAmount(3 + (2 * ((DataInputView) getView()).getComboBox()
                                                                .getSelectedIndex()));
  }

  // ---------------------------------------- Private methods -----------------------------------

  /**
   * Clears the players and match names.
   */
  private void clearNames() {
    Main.getMatch()
        .getPlayers()
        .forEach(p -> p.setName(""));

    Main.getMatch()
        .setTournamentName("");
  }

  /**
   * Checks if the given string matches the string validation regex.
   *
   * @param string The string to validate.
   *
   * @return Whether the string matches the string validation regex or not.
   */
  private boolean validString(String string) {
    return Pattern.matches(Main.NAMES_VALIDATION_REGEX, string);
  }

  /**
   * Checks if the given name has at most MAX_NAME_LEN characters,
   * is not empty or blank and if there isn't already a player
   * with that name.
   *
   * @param name The name to validate.
   *
   * @return If the given name is valid according to
   *         the specified conditions.
   */
  private boolean validName(String name) {
    return name.length() <= Main.MAX_NAME_LEN && !name.isBlank()
           && !name.isEmpty() && !alreadyExists(name);
  }

  /**
   * Checks if there is already a player with the specified name.
   *
   * @param name Name to validate.
   *
   * @return Whether there is already a player with the specified name or not.
   */
  private boolean alreadyExists(String name) {
    return Main.getMatch()
               .getPlayers()
               .stream()
               .anyMatch(p -> p.getName()
                               .equals(name));
  }
}