package duxtennis.controllers;

import duxtennis.Main;
import duxtennis.models.Views;
import duxtennis.views.DataInputView;

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

    ((DataInputView) getView()).getPlayer1Slider()
                               .setValue(SLIDER_INI);

    ((DataInputView) getView()).getPlayer1TextField()
                               .setText("");

    ((DataInputView) getView()).getPlayer2TextField()
                               .setText("");

    ((DataInputView) getView()).getTournamentTextField()
                               .setText("");

    ((DataInputView) getView()).getContinueButton()
                               .setEnabled(false);
  }

  /**
   * 'Back' button event handler.
   *
   * <p>Resets the controlled view to its default values,
   * makes the controlled view invisible and shows the
   * main menu view.
   */
  public void backButtonEvent() {
    resetView();

    Main.getController(Views.MAIN_MENU)
        .showView();
  }

  /**
   * TODO
   */
  public void textFieldEvent() {
    // TODO
  }
}