package duxtennis.controllers;

import duxtennis.Main;
import duxtennis.models.Match;
import duxtennis.models.Player;
import duxtennis.models.Views;
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

  // ---------------------------------------- Public methods ------------------------------------

  /**
   * Updates the data shown in the current match table.
   * This includes the players points, the players games won
   * and the players sets won.
   */
  public void updateTable() {
    drawPoints();
    drawGamesWon();
    drawSetsWon();
  }

  /**
   * Updates the players points in the current match table.
   */
  public void drawPoints() {
    Main.getMatch()
        .getPlayers()
        .forEach(p -> {
          if (p.getGamePoints() > 40) {
            ((CurrentMatchView) getView()).getTable()
                                          .setValueAt("40 (" + (p.getGamePoints() - 40) + ")",
                                                      Main.getMatch()
                                                          .getPlayers()
                                                          .indexOf(p) + 1, 4);
          } else {
            ((CurrentMatchView) getView()).getTable()
                                          .setValueAt(Integer.toString(p.getGamePoints()),
                                                      Main.getMatch()
                                                          .getPlayers()
                                                          .indexOf(p) + 1, 4);
          }
        });
  }

  /**
   * Updates the players games won in the current match table.
   */
  public void drawGamesWon() {
    Main.getMatch()
        .getPlayers()
        .forEach(p -> {
          if (p.getGamesWon() > Match.GAMES_TO_WIN_SET + 1) {
            ((CurrentMatchView) getView()).getTable()
                                          .setValueAt(Match.GAMES_TO_WIN_SET + " ("
                                                    + (p.getGamesWon() - Match.GAMES_TO_WIN_SET + 1)
                                                      + ")",
                                                      Main.getMatch()
                                                          .getPlayers()
                                                          .indexOf(p) + 1, 3);
          } else {
            ((CurrentMatchView) getView()).getTable()
                                          .setValueAt(Integer.toString(p.getGamesWon()),
                                                      Main.getMatch()
                                                          .getPlayers()
                                                          .indexOf(p) + 1, 3);
          }
        });
  }

  /**
   * Updates the players sets won in the current match table.
   */
  public void drawSetsWon() {
    Player player1 = Main.getMatch()
                         .getPlayers()
                         .get(0);

    Player player2 = Main.getMatch()
                         .getPlayers()
                         .get(1);

    ((CurrentMatchView) getView()).getTable()
                                  .setValueAt(Integer.toString(player1.getSetsWon()), 1, 2);

    ((CurrentMatchView) getView()).getTable()
                                  .setValueAt(Integer.toString(player2.getSetsWon()), 2, 2);
  }

  /**
   * Draws an 'X' in the table cell corresponding to the server player.
   *
   * @param server The server player.
   */
  public void drawServer(Player server) {
    int serverIndex = Main.getMatch()
                          .getPlayers()
                          .indexOf(server);

    ((CurrentMatchView) getView()).getTable()
                                  .setValueAt("X", 1 + serverIndex, 1);

    ((CurrentMatchView) getView()).getTable()
                                  .setValueAt("", 2 - serverIndex, 1);
  }

  /**
   * Updates the players names in the current match table.
   */
  public void drawPlayersNames() {
    for (int i = 0; i < 2; i++) {
      ((CurrentMatchView) getView()).getTable()
                                    .setValueAt(Main.getMatch()
                                                    .getPlayers()
                                                    .get(i)
                                                    .getName(), i + 1, 0);
    }
  }

  /**
   * When the match ends, the current match view is hidden,
   * and the match result view is set and displayed.
   */
  public void matchFinished() {
    hideView();

    ((MatchResultController) Main.getController(Views.MATCH_RESULT)).setupInterface();
    ((MatchResultController) Main.getController(Views.MATCH_RESULT)).showView();
  }

  // ---------------------------------------- Protected methods ---------------------------------

  /**
   * Makes the controlled view invisible and resets it to its default values.
   */
  @Override
  protected void resetView() {
    // Not needed here
  }

  /**
   * Updates the tournament name label and makes the controlled view visible.
   */
  @Override
  protected void showView() {
    ((CurrentMatchView) getView()).getTournamentNameLabel()
                                  .setText("Torneo \"" + Main.getMatch()
                                                             .getTournamentName() + "\"");
    getView().pack();
    getView().setLocationRelativeTo(null);
    getView().setVisible(true);
  }
}