package duxtennis.controllers;

import duxtennis.views.MatchResultView;

/**
 * Match result view controller class.
 *
 * @author Bonino, Francisco Ignacio.
 * @version 0.0.1
 * @since 09/09/2022
 */
public class MatchResultController extends Controller {

  // ---------------------------------------- Constructor ---------------------------------------

  /**
   * Builds the match result view controller.
   *
   * @param matchResultView View to control.
   */
  public MatchResultController(MatchResultView matchResultView) {
    super(matchResultView);
  }

  /**
   * Makes the controlled view invisible and resets it to its default values.
   */
  @Override
  protected void resetView() {
    // Not implemented yet
  }
}