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
    hideView();
    resetView();

    ((CurrentMatchController) Main.getController(Views.CURRENT_MATCH)).drawPlayersNames();
    ((CurrentMatchController) Main.getController(Views.CURRENT_MATCH)).updateTable();
    ((CurrentMatchController) Main.getController(Views.CURRENT_MATCH)).showView();

    Main.simulateMatch();
  }

  /**
   * Resets every parameter in the program and goes back to the main menu.
   */
  public void mainMenuButtonEvent() {
    hideView();
    resetView();

    Main.getMatch()
        .getPlayers()
        .forEach(p -> {
          p.setName("");
          p.setSkillPoints(0);
        });

    Main.getMatch()
        .setTournamentName("");

    Main.getMatch()
        .setMatchSetsAmount(0);

    Main.getController(Views.MAIN_MENU)
        .showView();
  }

  // ---------------------------------------- Protected methods ---------------------------------

  /**
   * Makes the controlled view invisible and resets the match
   * and the views to their default values. The players and the
   * tournament names are resetted only if the main menu button
   * is pressed, along with the players skill points and the
   * match sets amount.
   */
  @Override
  protected void resetView() {
    Main.getMatch()
        .getPlayers()
        .forEach(p -> {
          p.setGamePoints(0);
          p.setGamesWon(0);
          p.setServes(false);
          p.setSetsWon(0);
          p.setWinner(false);
        });

    Main.getMatch()
        .getFinishedSets()
        .clear();

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