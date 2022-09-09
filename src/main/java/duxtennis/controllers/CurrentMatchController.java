package duxtennis.controllers;

import duxtennis.Main;
import duxtennis.models.Player;
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
   * Bla.
   */
  public void updateTable() {
    drawPoints();
    drawGamesWon();
    drawSetsWon();
  }

  /**
   * Bla.
   */
  public void drawPoints() {
    Player player1 = Main.getMatch()
                         .getPlayers()
                         .get(0);

    Player player2 = Main.getMatch()
                         .getPlayers()
                         .get(1);

    ((CurrentMatchView) getView()).getTable()
                                  .setValueAt(Integer.toString(player1.getGamePoints()), 1, 4);

    ((CurrentMatchView) getView()).getTable()
                                  .setValueAt(Integer.toString(player2.getGamePoints()), 2, 4);
  }

  /**
   * Bla.
   */
  public void drawGamesWon() {
    Player player1 = Main.getMatch()
                         .getPlayers()
                         .get(0);

    Player player2 = Main.getMatch()
                         .getPlayers()
                         .get(1);

    ((CurrentMatchView) getView()).getTable()
                                  .setValueAt(Integer.toString(player1.getGamesWon()), 1, 3);

    ((CurrentMatchView) getView()).getTable()
                                  .setValueAt(Integer.toString(player2.getGamesWon()), 2, 3);
  }

  /**
   * Bla.
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
   * Updates the table cells with the players names.
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