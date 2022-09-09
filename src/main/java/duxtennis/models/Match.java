package duxtennis.models;

import java.util.Arrays;
import java.util.List;

/**
 * Match class.
 *
 * @author Bonino, Francisco Ignacio.
 * @version 0.0.1
 * @since 08/09/2022
 */
public class Match {

  // ---------------------------------------- Private fields ------------------------------------

  private int setsAmount;

  private Player player1;
  private Player player2;

  private String tournamentName;

  // ---------------------------------------- Constructor ---------------------------------------

  /**
   * Match constructor.
   *
   * @param player1        Player 1.
   * @param player2        Player 2.
   * @param tournamentName The tournament name.
   * @param setsAmount     The match sets amount.
   */
  public Match(Player player1, Player player2, String tournamentName, int setsAmount) {
    this.player1 = player1;
    this.player2 = player2;

    setTournamentName(tournamentName);
    setMatchSetsAmount(setsAmount);
  }

  // ---------------------------------------- Public methods ------------------------------------

  // ---------------------------------------- Getters -------------------------------------------

  /**
   * Gets the match sets amount.
   *
   * @return The match sets amount.
   */
  public int getSetsAmount() {
    return setsAmount;
  }

  /**
   * Gets the match players.
   *
   * @return The match players.
   */
  public List<Player> getPlayers() {
    return Arrays.asList(player1, player2);
  }

  /**
   * Gets the tournament name.
   *
   * @return The tournament name.
   */
  public String getTournamentName() {
    return tournamentName;
  }

  // ---------------------------------------- Setters -------------------------------------------

  /**
   * Updates the tournament name.
   *
   * @param tournamentName The tournament name.
   */
  public void setTournamentName(String tournamentName) {
    this.tournamentName = tournamentName;
  }

  /**
   * Updates the match sets amount.
   *
   * @param setsAmount The match sets amount.
  */
  public void setMatchSetsAmount(int setsAmount) {
    this.setsAmount = setsAmount;
  }
}