package duxtennis.controllers;

import duxtennis.Main;
import duxtennis.views.CurrentMatchView;

/**
 * Current match view controller class.
 *
 * @author Bonino, Francisco Ignacio.
 * @version 0.0.1
 * @since 08/09/2022
 */
public class CurrentMatchController extends Controller {

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
   * Updates the table cells with the players names.
   */
  public void updateTable() {
    for (int i = 0; i < 2; i++) {
      ((CurrentMatchView) getView()).getTable()
                                    .setValueAt(Main.getMatch()
                                                    .getPlayers()
                                                    .get(i)
                                                    .getName(), i + 1, 0);
    }
  }

  // ---------------------------------------- Protected methods ---------------------------------

  /**
   * Makes the controlled view invisible and resets it to its default values.
   */
  @Override
  protected void resetView() {
    // Not implemented here
  }
}