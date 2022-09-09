package duxtennis.utils;

import duxtennis.Main;
import duxtennis.controllers.CurrentMatchController;
import duxtennis.models.Match;
import duxtennis.models.Player;
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
    whoServes(true);

    Timer timer1s = new Timer(1000, null);

    timer1s.addActionListener(e -> generatePoints());
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
    int playerGamePoints = 15;

    Player pointWinner = match.getPlayers()
                              .get((randomGenerator.nextDouble()
                                    <= (double) match.getPlayers()
                                                     .get(0)
                                                     .getSkillPoints() / 100) ? 0 : 1);

    playerGamePoints += pointWinner.getGamePoints();

    if (playerGamePoints == 45) {
      playerGamePoints = 40;
    } else if (playerGamePoints > 40) {
      playerGamePoints = 0;
      playerWonGame(pointWinner);
    }

    pointWinner.setGamePoints(playerGamePoints);

    ((CurrentMatchController) Main.getController(Views.CURRENT_MATCH)).drawPoints();
  }

  /**
   * Bla.
   *
   * @param winner Bla.
   */
  private void playerWonGame(Player gameWinner) {
    gameWinner.setGamePoints(0);
    gameWinner.setGamesWon(gameWinner.getGamesWon() + 1);

    match.getPlayers()
         .get(1 - match.getPlayers()
                       .indexOf(gameWinner))
         .setGamePoints(0);

    ((CurrentMatchController) Main.getController(Views.CURRENT_MATCH)).updateTable();
  }
}