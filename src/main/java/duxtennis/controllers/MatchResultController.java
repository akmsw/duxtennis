package duxtennis.controllers;

import duxtennis.Main;
import duxtennis.models.Match;
import duxtennis.models.Player;
import duxtennis.models.Set;
import duxtennis.models.Views;
import duxtennis.views.DataInputView;
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
   * If the user wants a rematch, the match result view is hidden and resetted
   * to its default values, the match sets amount is resetted to the combobox
   * chosen option (it could be changed in
   * {@link duxtennis.utils.MatchSimulator#playerWonSet(Player, Player)}),
   * the current match table is updated and the match is simulated again.
   */
  public void rematchButtonEvent() {
    hideView();
    resetView();

    Main.getMatch()
        .setMatchSetsAmount(3 + (2 * ((DataInputView) Main.getController(Views.DATA_INPUT)
                                            .getView()).getComboBox().getSelectedIndex()));

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

    fillTable();
    getView().pack();
    getView().setLocationRelativeTo(null);
    getView().setVisible(true);
  }

  // ---------------------------------------- Private methods -----------------------------------

  /**
   * Fills the match result table with the sets results.
   */
  private void fillTable() {
    for (int i = 0; i < 2; i++) {
      ((MatchResultView) getView()).getTable()
                                   .setValueAt(Main.getMatch()
                                                   .getPlayers()
                                                   .get(i)
                                                   .getName(), i, 0);
    }


    for (int i = 0; i < Main.getMatch()
                            .getSetsAmount(); i++) {
      Set set = Main.getMatch()
                    .getFinishedSets()
                    .get(i);

      ((MatchResultView) getView()).getTable()
                                   .setValueAt(getWonGamesString(set.getLoserWonGames(), false),
                                               set.getLoserIndex(), i + 1);

      ((MatchResultView) getView()).getTable()
                                   .setValueAt(getWonGamesString(set.getWinnerWonGames(), true),
                                               set.getWinnerIndex(), i + 1);
    }
  }

  /**
   * Converts the games won to a string.
   *
   * <p>If the number of games won is more than the games
   * needed to win a set (there has been a tie), then the
   * string is formatted according to the standard tennis
   * results.
   *
   * @param wonGames Number of games won by the player.
   * @param winner   Whether the player is the set winner.
   *
   * @return The games won formatted string.
   */
  private String getWonGamesString(int wonGames, boolean winner) {
    if (wonGames > Match.GAMES_TO_WIN_SET) {
      if (winner) {
        return "7 (" + (wonGames - Match.GAMES_TO_WIN_SET) + ")";
      } else {
        return "6 (" + (wonGames - Match.GAMES_TO_WIN_SET) + ")";
      }
    }

    return Integer.toString(wonGames);
  }
}