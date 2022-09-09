package duxtennis.controllers;

import duxtennis.Main;
import duxtennis.models.Player;
import duxtennis.views.MatchResultView;
import java.util.stream.Collectors;

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
    String winnerName = Main.getMatch()
                            .getPlayers()
                            .stream()
                            .filter(Player::isWinner)
                            .collect(Collectors.toList())
                            .get(0)
                            .getName();

    ((MatchResultView) getView()).getTitleLabel()
                                 .setText("GANADOR DEL TORNEO \""
                                          + Main.getMatch().getTournamentName()
                                          + "\": " + winnerName);

    getView().pack();
    getView().setLocationRelativeTo(null);
    getView().setVisible(true);
  }
}