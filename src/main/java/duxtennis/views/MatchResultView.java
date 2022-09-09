package duxtennis.views;

import duxtennis.Main;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import net.miginfocom.swing.MigLayout;

/**
 * Match result view class.
 *
 * @author Bonino, Francisco Ignacio.
 * @version 0.0.1
 * @since 09/09/2022
 */
public class MatchResultView extends View {

  private static final String FRAME_TITLE = "Resultado del partido";

  // ---------------------------------------- Private fields ------------------------------------

  private JLabel titleLabel;

  private JPanel panel;

  private JTable table;

  // ---------------------------------------- Constructor ---------------------------------------

  /**
   * Construye una ventana de resultados.
   */
  public MatchResultView() {
    initializeInterface();
  }

  // ---------------------------------------- Public methods ------------------------------------

  /**
   * Initializes the view and makes it visible.
   */
  @Override
  public void initializeInterface() {
    panel = new JPanel(new MigLayout("wrap"));

    addLabel();
    addTable();
    addButtons();
    add(panel);
    setResizable(false);
    setTitle(FRAME_TITLE);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setIconImage(Main.ICON.getImage());
  }

  /**
   * Gets the title label.
   *
   * @return The title label.
   */
  public JLabel getTitleLabel() {
    return titleLabel;
  }

  // ---------------------------------------- Protected methods ---------------------------------

  /**
   * Adds the buttons to their corresponding panel.
   */
  @Override
  protected void addButtons() {
    JButton rematchButton = new JButton("Revancha");

    panel.add(rematchButton, "growx");
  }

  // ---------------------------------------- Private methods -----------------------------------

  /**
   * Adds the title label in the view panel.
   */
  private void addLabel() {
    titleLabel = new JLabel();

    titleLabel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
    titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    titleLabel.setBackground(Main.LIGHT_GREEN);
    titleLabel.setOpaque(true);

    panel.add(titleLabel, "growx, span");
  }

  /**
   * Adds the results table in the view panel.
   */
  private void addTable() {
    // TODO
  }
}