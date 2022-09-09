package duxtennis.utils;

import duxtennis.Main;
import duxtennis.controllers.CurrentMatchController;
import duxtennis.models.Match;
import duxtennis.models.Player;
import duxtennis.models.Set;
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

  // ---------------------------------------- Private constants ---------------------------------

  private static final int TIMER_DELAY_MS = 500;

  // ---------------------------------------- Private fields ------------------------------------

  private boolean matchEnded;

  private Match match;

  private Random randomGenerator;

  private Timer timer;

  // ---------------------------------------- Constructor ---------------------------------------

  /**
   * Builds the match simulator.
   */
  public MatchSimulator(Match match) {
    this.match = match;

    matchEnded = false;

    randomGenerator = new Random();
  }

  // ---------------------------------------- Public methods ------------------------------------

  /**
   * Starts the match simulation.
   */
  public void simulate() {
    whoServes(true);

    timer = new Timer(TIMER_DELAY_MS, null);

    timer.addActionListener(e -> {
      generatePoints();

      if (matchEnded) {
        ((CurrentMatchController) Main.getController(Views.CURRENT_MATCH)).matchFinished();
      }
    });
    timer.setRepeats(true);
    timer.start();
  }

  // ---------------------------------------- Private methods -----------------------------------

  /**
   * Decides who serves in the current game.
   *
   * <p>If it is the first match game, then the server is
   * chosen randomly. If not, the server player is toggled.
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
   * Generates a random number between 0.0 and 1.0, and a player is chosen
   * based on their probabilities.
   *
   * <p>Once the player is chosen, its game points are increased, and if
   * the player game points are more than 40 then the player is flagged
   * as the game winner.
   *
   * <p>Finally the players game points are updated in the table.
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
   * Resets the players game points to 0 and increases by 1
   * the won games amount of the finished game winner.
   *
   * <p>If the amount of games won by the winner is 6, then
   * the winner is flagged as the set winner.
   *
   * <p>Finally, the table data is updated.
   *
   * @param winner The game winner.
   */
  private void playerWonGame(Player gameWinner) {
    gameWinner.setGamePoints(0);

    match.getPlayers()
         .get(1 - match.getPlayers()
                       .indexOf(gameWinner))
         .setGamePoints(0);

    int gamesWon = gameWinner.getGamesWon() + 1;

    gameWinner.setGamesWon(gamesWon);

    if (gamesWon == 6) {
      playerWonSet(gameWinner);
      return;
    }

    ((CurrentMatchController) Main.getController(Views.CURRENT_MATCH)).updateTable();
  }

  /**
   * Creates a set and establishes its parameters. Then, resets
   * the players games won amount and increases by 1 the amount
   * of sets won by the set winner.
   *
   * <p>If the total amount of finished sets is the same as the
   * number of sets entered in the data input view, then the match
   * is finished. If not, a new server is chosen and the table data
   * is updated.
   *
   * @param setWinner The set winner.
   */
  private void playerWonSet(Player setWinner) {
    Player setLoser = match.getPlayers()
                           .get(1 - match.getPlayers()
                                         .indexOf(setWinner));

    match.addFinishedSet(new Set(setWinner));

    setWinner.setGamesWon(0);
    setLoser.setGamesWon(0);

    int setsWon = setWinner.getSetsWon() + 1;

    setWinner.setSetsWon(setsWon);

    if (setsWon + match.getPlayers()
                       .get(1 - match.getPlayers()
                                     .indexOf(setWinner))
                       .getSetsWon() == match.getSetsAmount()) {
      timer.stop();

      ((CurrentMatchController) Main.getController(Views.CURRENT_MATCH)).updateTable();

      matchEnded = true;

      return;
    }

    whoServes(false);

    ((CurrentMatchController) Main.getController(Views.CURRENT_MATCH)).updateTable();
  }
}