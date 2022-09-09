package duxtennis.controllers;

import duxtennis.views.CurrentMatchView;

/**
 * Current match view controller class.
 *
 * @author Bonino, Francisco Ignacio.
 * @version 0.0.1
 * @since 08/09/2022
 */
public class CurrentMatchController  extends Controller {

  // ---------------------------------------- Private constants ---------------------------------

  private static final int TABLE_COLUMNS = 5;
  private static final int TABLE_ROWS = 3;

  // ---------------------------------------- Constructor ---------------------------------------

  /**
   * Builds the current match view controller.
   *
   * @param currentMatchView View to control.
   */
  public CurrentMatchController(CurrentMatchView currentMatchView) {
    super(currentMatchView);
  }

  /**
   * Makes the controlled view invisible and resets it to its default values.
   */
  @Override
  protected void resetView() {
    // Not implemented here
  }
}