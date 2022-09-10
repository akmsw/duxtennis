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

  // ---------------------------------------- Private fields ------------------------------------

  private int winnerWonGames;
  private int loserWonGames;
  private int winnerIndex;
  private int loserIndex;

  // ---------------------------------------- Constructor ---------------------------------------

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

  // ---------------------------------------- Public methods ------------------------------------

  // ---------------------------------------- Getters -------------------------------------------

  /**
   * Gets the set winner index in the players list.
   *
   * @return The set winner index in the players list.
   */
  public int getWinnerIndex() {
    return winnerIndex;
  }

  /**
   * Gets the set loser index in the players list.
   *
   * @return The set loser index in the players list.
   */
  public int getLoserIndex() {
    return loserIndex;
  }

  /**
   * Gets the set winner won games amount.
   *
   * @return The set winner won games amount.
   */
  public int getWinnerWonGames() {
    return winnerWonGames;
  }

  /**
   * Gets the set loser won games amount.
   *
   * @return The set loser won games amount.
   */
  public int getLoserWonGames() {
    return loserWonGames;
  }
}