package duxtennis.models;

import duxtennis.Main;

/**
 * Set class.
 *
 * @author Bonino, Francisco Ignacio.
 * @version 0.0.1
 * @since 09/09/2022
 */
public class Set {

  private int winnerWonGames;
  private int loserWonGames;
  private int winnerIndex;
  private int loserIndex;

  /**
   * Builds a finished set.
   *
   * @param winner The set winner.
   */
  public Set(Player winner) {
    winnerIndex = Main.getMatch()
                      .getPlayers()
                      .indexOf(winner);

    loserIndex = 1 - winnerIndex;

    Player loser = Main.getMatch()
                       .getPlayers()
                       .get(loserIndex);

    winnerWonGames = winner.getGamesWon();
    loserWonGames = loser.getGamesWon();
  }

  public int getWinnerIndex() {
    return winnerIndex;
  }

  public int getLoserIndex() {
    return loserIndex;
  }

  public int getWinnerWonGames() {
    return winnerWonGames;
  }

  public int getLoserWonGames() {
    return loserWonGames;
  }
}