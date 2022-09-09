package duxtennis.utils;

import duxtennis.models.Match;

/**
 * Match simulator class.
 *
 * @author Bonino, Francisco Ignacio.
 * @version 0.0.1
 * @since 08/09/2022
 */
public class MatchSimulator {

  private Match match;

  /**
   * Builds the match simulator.
   */
  public MatchSimulator(Match match) {
    this.match = match;
  }

  /**
   * Starts the match simulation.
   */
  public void simulate() {
    match.getPlayers().forEach(p -> System.out.println(p.getSkillPoints()));
  }
}