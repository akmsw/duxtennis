package duxtennis.utils;

import duxtennis.Main;
import duxtennis.controllers.CurrentMatchController;
import duxtennis.models.Match;
import duxtennis.models.Player;
import duxtennis.models.Views;
import java.util.Random;
import java.util.stream.Collectors;
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

  private Timer timer1s;

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

    timer1s = new Timer(1000, null);

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
    } else {
      Player lastServer = match.getPlayers()
                               .stream()
                               .filter(Player::serves)
                               .collect(Collectors.toList())
                               .get(0);

      lastServer.setServes(false);

      match.getPlayers()
           .get(1 - match.getPlayers()
                         .indexOf(lastServer))
           .setServes(true);

      ((CurrentMatchController) Main.getController(Views.CURRENT_MATCH))
           .drawServer(match.getPlayers()
                            .get(1 - match.getPlayers()
                                          .indexOf(lastServer)));
    }
  }

  /**
   * Bla.
   */
  private void generatePoints() {
    Player pointWinner = match.getPlayers()
                              .get((randomGenerator.nextDouble()
                                    <= (double) match.getPlayers()
                                                     .get(0)
                                                     .getSkillPoints() / 100) ? 0 : 1);

    int playerGamePoints = pointWinner.getGamePoints() + 15;

    if (playerGamePoints == 45) {
      playerGamePoints = 40;
    } else if (playerGamePoints > 40) {
      playerWonGame(pointWinner);
      return;
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

    match.getPlayers()
         .get(1 - match.getPlayers()
                       .indexOf(gameWinner))
         .setGamePoints(0);

    int gamesWon = gameWinner.getGamesWon() + 1;

    if (gamesWon == 6) {
      playerWonSet(gameWinner);
      return;
    }

    gameWinner.setGamesWon(gamesWon);

    ((CurrentMatchController) Main.getController(Views.CURRENT_MATCH)).updateTable();
  }

  /**
   * Bla.
   *
   * @param setWinner Bla.
   */
  private void playerWonSet(Player setWinner) {
    setWinner.setGamesWon(0);

    match.getPlayers()
         .get(1 - match.getPlayers()
                       .indexOf(setWinner))
         .setGamesWon(0);

    int setsWon = setWinner.getSetsWon() + 1;

    setWinner.setSetsWon(setsWon);

    if (setsWon + match.getPlayers()
                       .get(1 - match.getPlayers()
                                     .indexOf(setWinner))
                       .getSetsWon() == match.getSetsAmount()) {
      timer1s.stop();

      ((CurrentMatchController) Main.getController(Views.CURRENT_MATCH)).updateTable();

      Main.showErrorMessage("Partido terminado!");

      return;
    }

    whoServes(false);

    ((CurrentMatchController) Main.getController(Views.CURRENT_MATCH)).updateTable();
  }
}