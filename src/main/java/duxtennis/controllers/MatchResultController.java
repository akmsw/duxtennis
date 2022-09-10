package duxtennis.controllers;

import duxtennis.Main;
import duxtennis.models.Player;
import duxtennis.models.Views;
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
   * Initializes the match result view interface.
   * This method should be called only after the match has endede
   * in order to get the player names and every set result.
   */
  public void setupInterface() {
    ((MatchResultView) getView()).initializeInterface();
  }

  /**
   * Bla.
   */
  public void rematchButtonEvent() {

  }

  /**
   * Bla.
   */
  public void mainMenuButtonEvent() {
    hideView();
    resetView();

    Main.getController(Views.MAIN_MENU)
        .showView();
  }

  // ---------------------------------------- Protected methods ---------------------------------

  /**
   * Makes the controlled view invisible and resets the match
   * and the views to their default values.
   */
  @Override
  protected void resetView() {
    Main.getMatch()
        .getPlayers()
        .forEach(p -> {
          p.setGamePoints(0);
          p.setGamesWon(0);
          p.setName("");
          p.setServes(false);
          p.setSetsWon(0);
          p.setSkillPoints(0);
          p.setWinner(false);
        });

    Main.getMatch()
        .getFinishedSets()
        .clear();

    Main.getMatch()
        .setMatchSetsAmount(0);

    Main.getMatch()
        .setTournamentName("");

    ((DataInputController) Main.getController(Views.DATA_INPUT)).resetView();

    getView().dispose();
    setView(new MatchResultView());
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