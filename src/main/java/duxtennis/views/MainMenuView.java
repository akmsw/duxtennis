package duxtennis.views;

import duxtennis.Main;
import duxtennis.controllers.MainMenuController;
import duxtennis.models.Views;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import net.miginfocom.swing.MigLayout;

/**
 * Main menu view class.
 *
 * @author Bonino, Francisco Ignacio.
 * @version 0.0.1
 * @since 07/09/2022
 */
public class MainMenuView extends View {

  // ---------------------------------------- Private constants ---------------------------------

  private static final String BG_IMG_FILENAME = "bg.png";
  private static final String GROWX = "growx";
  private static final String FRAME_TITLE = Main.PROGRAM_TITLE;

  // ---------------------------------------- Private fields ------------------------------------

  private JPanel masterPanel;

  // ---------------------------------------- Constructor ---------------------------------------

  /**
   * Construye la ventana principal.
   */
  public MainMenuView() {
    initializeInterface();
  }

  // ---------------------------------------- Protected methods ---------------------------------

  /**
   * Initializes the view and makes it visible.
   */
  @Override
  protected void initializeInterface() {
    masterPanel = new JPanel(new MigLayout("wrap"));

    addBackground();
    addButtons();
    add(masterPanel);
    setResizable(false);
    setTitle(FRAME_TITLE);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setIconImage(Main.ICON.getImage());
    pack();
    setLocationRelativeTo(null);
  }

  /**
   * Adds the buttons to their corresponding panel.
   */
  @Override
  protected void addButtons() {
    JButton startButton = new JButton("Comenzar");
    JButton exitButton = new JButton("Salir");

    startButton.addActionListener(e ->
        ((MainMenuController) Main.getController(Views.MAIN_MENU)).startButtonEvent()
    );

    exitButton.addActionListener(e -> System.exit(0));

    masterPanel.add(startButton, GROWX);
    masterPanel.add(exitButton, GROWX);
  }

  // ---------------------------------------- Private methods -----------------------------------

  /**
   * Adds the background image to the panel.
   */
  private void addBackground() {
    ImageIcon bgImage = new ImageIcon(getClass().getClassLoader()
                                                .getResource(Main.IMG_PATH
                                                             + BG_IMG_FILENAME));

    JLabel bgLabel = new JLabel("", bgImage, SwingConstants.CENTER);

    masterPanel.add(bgLabel, GROWX);
  }
}