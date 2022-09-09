package duxtennis.utils;

import duxtennis.Main;
import duxtennis.models.Match;
import duxtennis.models.Views;
import duxtennis.views.CurrentMatchView;
import javax.swing.Timer;

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
    Timer timer = new Timer(1000, null);

    timer.addActionListener(e -> whoServes());
    timer.setRepeats(true);
    timer.start();
  }

  /**
   * Bla.
   */
  private void whoServes() {
    if (Math.random() <= (double) Main.getMatch()
                                      .getPlayers()
                                      .get(0)
                                      .getSkillPoints() / 100) {
      match.getPlayers()
           .get(0)
           .setServes(true);

      match.getPlayers()
           .get(1)
           .setServes(false);

      ((CurrentMatchView) Main.getController(Views.CURRENT_MATCH)
                              .getView()).getTable()
                                         .setValueAt("X", 1, 1);

      ((CurrentMatchView) Main.getController(Views.CURRENT_MATCH)
                              .getView()).getTable()
                                         .setValueAt("", 2, 1);
    } else {
      match.getPlayers()
           .get(0)
           .setServes(false);

      match.getPlayers()
           .get(1)
           .setServes(true);

      ((CurrentMatchView) Main.getController(Views.CURRENT_MATCH)
                              .getView()).getTable()
                                         .setValueAt("", 1, 1);

      ((CurrentMatchView) Main.getController(Views.CURRENT_MATCH)
                              .getView()).getTable()
                                         .setValueAt("X", 2, 1);
    }

    Main.getMatch().getPlayers().forEach(p -> System.out.println(p.getName() + "->" + p.serves()));
    System.out.println("/////////////////////////////////////////////");
  }
}