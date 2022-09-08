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

  private int skillPoints; // 0 to 100

  private String name;

  // ---------------------------------------- Constructor ---------------------------------------

  /**
   * Builds a basic player with the received parameters.
   *
   * @param name     Player name.
   */
  public Player(String name) {
    setName(name);
    setSkillPoints(0);
    setServes(false);
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

  // ---------------------------------------- Setters -------------------------------------------

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
}