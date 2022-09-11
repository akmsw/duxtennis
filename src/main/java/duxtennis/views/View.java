package duxtennis.views;

import javax.swing.JFrame;

/**
 * Abstract class that specifies the basic views methods.
 *
 * @author Bonino, Francisco Ignacio.
 * @version 0.0.1
 * @since 07/09/2022
 */
public abstract class View extends JFrame {

  // ---------------------------------------- Abstract protected methods ------------------------

  /**
   * Initializes the view and makes it visible.
   */
  protected abstract void initializeInterface();

  /**
   * Adds the buttons to their corresponding panel.
   */
  protected abstract void addButtons();
}