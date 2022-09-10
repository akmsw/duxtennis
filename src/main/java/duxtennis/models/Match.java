package duxtennis.models;

import java.util.ArrayList;
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

  private boolean deuce;
  private boolean tie5;
  private boolean tie6;

  private int setsAmount;

  private String tournamentName;

  private List<Player> players;
  private List<Set> finishedSets;

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
    finishedSets = new ArrayList<>();
    players = new ArrayList<>();

    players.add(player1);
    players.add(player2);

    setTournamentName(tournamentName);
    setMatchSetsAmount(setsAmount);
    setDeuce(false);
  }

  // ---------------------------------------- Public methods ------------------------------------

  /**
   * Adds a finished set to the list.
   *
   * @param set Finished set to add.
   */
  public void addFinishedSet(Set set) {
    finishedSets.add(set);
  }

  // ---------------------------------------- Getters -------------------------------------------

  /**
   * Returns whether the match is in deuce or not.
   *
   * @return Whether the match is in deuce or not.
   */
  public boolean deuce() {
    return deuce;
  }

  /**
   * Returns whether the match is in a tie with 5 games.
   *
   * @return Whether the match is in a tie with 5 games.
   */
  public boolean isTie5() {
    return tie5;
  }

  /**
   * Returns whether the match is in a tie with 6 games.
   *
   * @return Whether the match is in a tie with 6 games.
   */
  public boolean isTie6() {
    return tie6;
  }

  /**
   * Gets the match sets amount.
   *
   * @return The match sets amount.
   */
  public int getSetsAmount() {
    return setsAmount;
  }

  /**
   * Gets the tournament name.
   *
   * @return The tournament name.
   */
  public String getTournamentName() {
    return tournamentName;
  }

  /**
   * Gets the match players.
   *
   * @return The match players.
   */
  public List<Player> getPlayers() {
    return players;
  }

  /**
   * Gets the finished sets.
   *
   * @return The finished sets.
   */
  public List<Set> getFinishedSets() {
    return finishedSets;
  }

  // ---------------------------------------- Setters -------------------------------------------

  /**
   * Updates the deuce flag.
   *
   * @param deuce The deuce flag new value.
   */
  public void setDeuce(boolean deuce) {
    this.deuce = deuce;
  }

  /**
   * Updates the 5-games tie flag.
   *
   * @param tie5 The 5-games tie flag new value.
   */
  public void setTie5(boolean tie5) {
    this.tie5 = tie5;
  }

  /**
   * Updates the 6-games tie flag.
   *
   * @param tie6 The 6-games tie flag new value.
   */
  public void setTie6(boolean tie6) {
    this.tie6 = tie6;
  }

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