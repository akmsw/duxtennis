package duxtennis.models;

/**
 * Players class.
 *
 * @author Bonino, Francisco Ignacio.
 * @version 0.0.1
 * @since 08/09/2022
 */
public class Player {

  // ---------------------------------------- Private fields ------------------------------------

  private boolean serves;
  private boolean winner;

  private int setsWon;
  private int skillPoints; // 0 to 100
  private int gamePoints;
  private int gamesWon;

  private String name;

  // ---------------------------------------- Constructor ---------------------------------------

  /**
   * Builds a basic player with the received parameters.
   *
   * @param name Player name.
   */
  public Player(String name) {
    setName(name);
    setSkillPoints(0);
    setGamePoints(0);
    setGamesWon(0);
    setSetsWon(0);
    setServes(false);
    setWinner(false);
  }

  // ---------------------------------------- Public methods ------------------------------------

  // ---------------------------------------- Getters -------------------------------------------

  /**
   * Gets whether the player serves or not in the game.
   *
   * @return Whether the player serves or not in the game.
   */
  public boolean serves() {
    return serves;
  }

  /**
   * Gets the player's current game points.
   *
   * @return The player's current game points.
   */
  public int getGamePoints() {
    return gamePoints;
  }

  /**
   * Gets the player's games won amount.
   *
   * @return The player's games won amount.
   */
  public int getGamesWon() {
    return gamesWon;
  }

  /**
   * Gets the player's sets won amount.
   *
   * @return The player's sets won amount.
   */
  public int getSetsWon() {
    return setsWon;
  }

  /**
   * Gets the player's skill points.
   *
   * @return The player's skill points.
   */
  public int getSkillPoints() {
    return skillPoints;
  }

  /**
   * Gets the player's name.
   *
   * @return The player's name.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns whether the player is the match winner or not.
   *
   * @return Whether the player is the match winner or not.
   */
  public boolean isWinner() {
    return winner;
  }

  // ---------------------------------------- Setters -------------------------------------------

  /**
   * Updates the player's current game points.
   *
   * @param gamePoints The player's current game points.
   */
  public void setGamePoints(int gamePoints) {
    this.gamePoints = gamePoints;
  }

  /**
   * Updates the player's games won amount.
   *
   * @param gamesWon The player's games won amount.
   */
  public void setGamesWon(int gamesWon) {
    this.gamesWon = gamesWon;
  }


  /**
   * Updates the player's sets won amount.
   *
   * @param setsWon The player's sets won amount.
   */
  public void setSetsWon(int setsWon) {
    this.setsWon = setsWon;
  }

  /**
   * Updates the player's name.
   *
   * @param name The player's new name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Updates the player's skill points.
   *
   * @param skillPoints The player's new skill points.
   */
  public void setSkillPoints(int skillPoints) {
    this.skillPoints = skillPoints;
  }

  /**
   * Updates the player's serving state.
   *
   * @param serves Whether the player serves or not in the game.
   */
  public void setServes(boolean serves) {
    this.serves = serves;
  }

  /**
   * Sets whether the player is the match winner or not.
   *
   * @param winner Whether the player is the match winner or not.
   */
  public void setWinner(boolean winner) {
    this.winner = winner;
  }
}