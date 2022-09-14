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

  private int gamesToWinSet;

  private Match match;

  private Random randomGenerator;

  private Timer timer;

  // ---------------------------------------- Constructor ---------------------------------------

  /**
   * Builds the match simulator.
   *
   * @param match The match object to use in the simulation.
   */
  public MatchSimulator(Match match) {
    this.match = match;

    matchEnded = false;
    gamesToWinSet = Match.GAMES_TO_WIN_SET;

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

      Player newServer = match.getPlayers()
                              .get(1 - match.getPlayers()
                                            .indexOf(lastServer));

      lastServer.setServes(false);
      newServer.setServes(true);

      ((CurrentMatchController) Main.getController(Views.CURRENT_MATCH)).drawServer(newServer);
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

    int playerGamePoints;

    if (match.deuce()) {
      playerGamePoints = pointWinner.getGamePoints() + 1;
    } else {
      playerGamePoints = pointWinner.getGamePoints() + Match.GAMES_STEP;

      if (playerGamePoints == 45) {
        playerGamePoints = 40;
      }
    }

    pointWinner.setGamePoints(playerGamePoints);

    Player pointLoser = match.getPlayers()
                             .get(1 - match.getPlayers()
                                           .indexOf(pointWinner));

    if (checkDraw(pointWinner.getGamePoints(), pointLoser.getGamePoints(), Match.DEUCE_POINTS)) {
      match.setDeuce(true);
    }

    if (match.deuce() && pointWinner.getGamePoints() == pointLoser.getGamePoints() + 2) {
      match.setDeuce(false);
      playerWonGame(pointWinner, pointLoser);
      return;
    }

    if (!match.deuce() && pointWinner.getGamePoints() > Match.POINTS_TO_WIN_GAME) {
      playerWonGame(pointWinner, pointLoser);
      return;
    }

    ((CurrentMatchController) Main.getController(Views.CURRENT_MATCH)).drawPoints();
  }

  /**
   * Resets the players game points to 0 and increases by 1
   * the won games amount of the finished game winner.
   *
   * <p>The game winner is established according to the game
   * rules explained in the README.md file.
   *
   * <p>Finally, the table data is updated.
   *
   * @param gameWinner The game winner.
   * @param gameLoser The game loser.
   */
  private void playerWonGame(Player gameWinner, Player gameLoser) {
    gameWinner.setGamePoints(0);
    gameLoser.setGamePoints(0);

    int gamesWon = gameWinner.getGamesWon() + 1;

    gameWinner.setGamesWon(gamesWon);

    if (checkDraw(gameWinner.getGamesWon(), gameLoser.getGamesWon(), Match.GAMES_TO_WIN_SET - 1)) {
      match.setTie5(true);

      gamesToWinSet = Match.GAMES_TO_WIN_SET + 1;
    }

    if (checkDraw(gameWinner.getGamesWon(), gameLoser.getGamesWon(), Match.GAMES_TO_WIN_SET)) {
      match.setTie5(false);
      match.setTie6(true);

      gamesToWinSet = Match.GAMES_TO_WIN_SET + 7;
    }

    if (match.isTieBreak() && gameWinner.getGamePoints() == gameLoser.getGamePoints() + 2) {
      playerWonSet(gameWinner, gameLoser);
      return;
    }

    if (gameWinner.getGamesWon() == gamesToWinSet) {
      if (checkDraw(gameWinner.getGamesWon(), gameLoser.getGamesWon(), gamesToWinSet)) {
        match.setTieBreak(true);
      }

      playerWonSet(gameWinner, gameLoser);
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
   * <p>The set winner is established according to the game rules
   * explained in the README.md file.
   *
   * @param setWinner The set winner.
   * @param setLoser The set loser.
   */
  private void playerWonSet(Player setWinner, Player setLoser) {
    match.addFinishedSet(new Set(setWinner));

    setWinner.setGamesWon(0);
    setLoser.setGamesWon(0);

    int setsWon = setWinner.getSetsWon() + 1;

    setWinner.setSetsWon(setsWon);

    if (matchEnd(setWinner, setLoser)) {
      timer.stop();

      if (match.getSetsAmount() != setWinner.getSetsWon() + setLoser.getSetsWon()) {
        match.setMatchSetsAmount(setWinner.getSetsWon());
      }

      ((CurrentMatchController) Main.getController(Views.CURRENT_MATCH)).updateTable();

      setWinner.setWinner(true);

      matchEnded = true;

      return;
    }

    if (match.isTie5() || match.isTie6()) {
      match.setTie5(false);
      match.setTie6(false);
      match.setTieBreak(false);

      gamesToWinSet = Match.GAMES_TO_WIN_SET;
    }

    whoServes(false);

    ((CurrentMatchController) Main.getController(Views.CURRENT_MATCH)).updateTable();
  }

  /**
   * Checks whether the match endind conditions are met.
   *
   * <p>A match ends when every set in the match has been
   * finished, or if a player takes advantage in more than
   * half of the match sets.
   *
   * <p>For example, in a 3 sets match, if a player gets
   * 2-0 the match ends because it is not possible for
   * the other player to even reach a draw. The same happens
   * with 3-0 or 3-1 in a 5 sets match.
   *
   * @param setWinner The set winner.
   * @param setLoser  The set loser.
   *
   * @return Whether the match endind conditions are met.
   */
  private boolean matchEnd(Player setWinner, Player setLoser) {
    return setWinner.getSetsWon() + setLoser.getSetsWon() == match.getSetsAmount()
           || (setWinner.getSetsWon() > match.getSetsAmount() / 2
               && match.getSetsAmount() - setWinner.getSetsWon()
                  < match.getSetsAmount() - setLoser.getSetsWon());
  }

  /**
   * Checks whether both players have the same
   * specified number in a field.
   *
   * @param player1Field Player 1 field to check.
   * @param player2Field Player 2 field to check.
   * @param reference    Reference to use.
   *
   * @return Whether both players have the same specified number in a field.
   */
  private boolean checkDraw(int player1Field, int player2Field, int reference) {
    return player1Field == reference
           && player1Field == player2Field;
  }
}