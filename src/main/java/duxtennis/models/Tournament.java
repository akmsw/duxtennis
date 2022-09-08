package duxtennis.models;

import java.util.Arrays;
import java.util.List;

/**
 * Tournament class.
 *
 * @author Bonino, Francisco Ignacio.
 * @version 0.0.1
 * @since 08/09/2022
 */
public class Tournament {

  // ---------------------------------------- Private fields ------------------------------------

  private int setsAmount;

  private Player player1;
  private Player player2;

  private String name;

  // ---------------------------------------- Constructor ---------------------------------------

  /**
   * Tournament constructor.
   *
   * @param player1    Player 1.
   * @param player2    Player 2.
   * @param name       The tournament name.
   * @param setsAmount The tournament sets amount.
   */
  public Tournament(Player player1, Player player2, String name, int setsAmount) {
    this.player1 = player1;
    this.player2 = player2;

    setName(name);
    setMatchSetsAmount(setsAmount);
  }

  // ---------------------------------------- Public methods ------------------------------------

  // ---------------------------------------- Getters -------------------------------------------

  /**
   * Gets the tournament sets amount.
   *
   * @return The tournament sets amount.
   */
  public int getSetsAmount() {
    return setsAmount;
  }

  /**
   * Gets the tournament players.
   *
   * @return The tournament players.
   */
  public List<Player> getPlayers() {
    return Arrays.asList(player1, player2);
  }

  /**
   * Gets the tournament name.
   *
   * @return The tournament name.
   */
  public String getName() {
    return name;
  }

  // ---------------------------------------- Setters -------------------------------------------

  /**
   * Updates the tournament name.
   *
   * @param name The tournament name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Updates the tournament sets amount.
   *
   * @param setsAmount The tournament sets amount.
  */
  public void setMatchSetsAmount(int setsAmount) {
    this.setsAmount = setsAmount;
  }
}