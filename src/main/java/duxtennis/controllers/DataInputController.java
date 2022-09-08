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

  // ---------------------------------------- Constructor ---------------------------------------

  /**
   * Builds the names input view controller.
   *
   * @param namesInputView View to control.
   */
  public DataInputController(DataInputView namesInputView) {
    super(namesInputView);
  }

  // ---------------------------------------- Public methods ------------------------------------

  /**
   * Resets the controlled view to its default values
   * and makes it invisible.
   */
  @Override
  public void resetView() {
    hideView();

    // TODO
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