package duxtennis.utils;

import duxtennis.Main;
import duxtennis.controllers.CurrentMatchController;
import duxtennis.models.Match;
import duxtennis.models.Views;
import java.util.Random;
import javax.swing.Timer;

/**
 * Match simulator class.
 *
 * @author Bonino, Francisco Ignacio.
 * @version 0.0.1
 * @since 08/09/2022
 */
public class MatchSimulator {

  // ---------------------------------------- Private fields ------------------------------------

  private Match match;

  private Random randomGenerator;

  // ---------------------------------------- Constructor ---------------------------------------

  /**
   * Builds the match simulator.
   */
  public MatchSimulator(Match match) {
    this.match = match;

    randomGenerator = new Random();
  }

  // ---------------------------------------- Public methods ------------------------------------

  /**
   * Starts the match simulation.
   */
  public void simulate() {
    Timer timer1s = new Timer(1000, null);

    timer1s.addActionListener(e -> {
      whoServes(true);
      generatePoints();
    });
    timer1s.setRepeats(true);
    timer1s.start();
  }

  // ---------------------------------------- Private methods -----------------------------------

  /**
   * Decides who serves in the current game.
   *
   * <p>If it is the first match game, then the server is
   * chosen randomly.
   *
   * @param firstTime Whether is the first game or not.
   */
  private void whoServes(boolean firstTime) {
    if (firstTime) {
      int serverIndex = randomGenerator.nextInt(2);

      match.getPlayers()
           .get(serverIndex)
           .setServes(true);

      match.getPlayers()
           .get(1 - serverIndex)
           .setServes(false);

      ((CurrentMatchController) Main.getController(Views.CURRENT_MATCH))
           .drawServer(match.getPlayers()
                            .get(serverIndex));
    }
  }

  /**
   * Bla.
   */
  private void generatePoints() {
    if (randomGenerator.nextDouble() <= (double) Main.getMatch()
                                                     .getPlayers()
                                                     .get(0)
                                                     .getSkillPoints() / 100) {
      Main.getMatch()
          .getPlayers()
          .get(0)
          .setGamePoints(15);

      Main.getMatch()
          .getPlayers()
          .get(1)
          .setGamePoints(0);
    } else {
      Main.getMatch()
          .getPlayers()
          .get(1)
          .setGamePoints(15);

      Main.getMatch()
          .getPlayers()
          .get(0)
          .setGamePoints(0);
    }

    ((CurrentMatchController) Main.getController(Views.CURRENT_MATCH)).drawPoints();
  }
}