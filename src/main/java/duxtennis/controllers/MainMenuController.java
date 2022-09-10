package duxtennis.controllers;

import duxtennis.Main;
import duxtennis.models.Views;
import duxtennis.views.MainMenuView;

/**
 * Main menu view controller class.
 *
 * @author Bonino, Francisco Ignacio.
 * @version 0.0.1
 * @since 07/09/2022
 */
public class MainMenuController extends Controller {

  // ---------------------------------------- Constructor ---------------------------------------

  /**
   * Builds the main menu view controller.
   *
   * @param mainMenuView View to control.
   */
  public MainMenuController(MainMenuView mainMenuView) {
    super(mainMenuView);
  }

  // ---------------------------------------- Public methods ------------------------------------

  /**
   * Makes the controlled view visible.
   */
  @Override
  public void showView() {
    getView().setVisible(true);
  }

  /**
   * 'Start' button event handler.
   *
   * <p>Makes the controlled view invisible
   * and shows the names input view.
   */
  public void startButtonEvent() {
    hideView();

    Main.getController(Views.DATA_INPUT)
        .showView();
  }

  // ---------------------------------------- Protected methods ---------------------------------

  /**
   * Resets the controlled view to its default values.
   */
  @Override
  protected void resetView() {
    // Not needed in this controller
  }
}