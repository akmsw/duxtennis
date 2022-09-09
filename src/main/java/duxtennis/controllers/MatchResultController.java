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

  // ---------------------------------------- Public methods ------------------------------------

  /**
   * Bla.
   */
  public void updateTable() {
    ((MatchResultView) getView()).initializeInterface();
  }

  // ---------------------------------------- Protected methods ---------------------------------

  /**
   * Makes the controlled view invisible and resets it to its default values.
   */
  @Override
  protected void resetView() {
    // Not implemented yet
  }

  /**
   * Updates the title name label and makes the controlled view visible.
   */
  @Override
  protected void showView() {
    ((MatchResultView) getView()).getTitleLabel()
                                 .setText("PARTIDO FINALIZADO");

    getView().pack();
    getView().setLocationRelativeTo(null);
    getView().setVisible(true);
  }
}