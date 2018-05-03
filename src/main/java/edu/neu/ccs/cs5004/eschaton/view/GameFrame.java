package edu.neu.ccs.cs5004.eschaton.view;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

import edu.neu.ccs.cs5004.eschaton.model.Model;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.DeckPanel;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.MainPanel;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.MapPanel;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.PlayerPanel;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.TilePanel;


public class GameFrame extends JPanel {

  private static JFrame FRAME;
  private static Window PANEL;
  private static TilePanel TILE_PANEL;
  private static DeckPanel DECK_PANEL;
  private static MapPanel MAP_PANEL;
  private static PlayerPanel PLAYER_PANEL;
  private static MainPanel MAIN_PANEL;
  private Model model;


  public GameFrame(Model model) throws IOException {
    this.FRAME = new JFrame(model.getConfig().GAME_NAME);
    this.PANEL = new Window(model.getConfig().GAME_NAME, model.getConfig().SCREEN_WIDTH, model.getConfig().SCREEN_HEIGHT);
    this.model = model;
    createAndShowGUI();
  }

  private void createAndShowGUI() throws IOException {
    FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    PANEL.setLayout(null);
    FRAME.getContentPane().add(PANEL);
    FRAME.pack();
    FRAME.setVisible(true);
    FRAME.setResizable(true);

    TILE_PANEL = new TilePanel();
    FRAME.getContentPane().add(TILE_PANEL.getPanel());

    DECK_PANEL = new DeckPanel(model);
    FRAME.getContentPane().add(DECK_PANEL.getPanel());

    MAP_PANEL = new MapPanel(getDeckPanel(), getTilePanel(), model);
    FRAME.getContentPane().add(MAP_PANEL.getPanel());

    PLAYER_PANEL = new PlayerPanel( this, model);
    FRAME.getContentPane().add(PLAYER_PANEL.getPanel());

    MAIN_PANEL = new MainPanel();
    FRAME.getContentPane().add(MAIN_PANEL.getPanel());
  }

  public void launch() throws IOException {

    javax.swing.SwingUtilities.invokeLater(
        new Runnable(){ public void run(){
          try {
            createAndShowGUI();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }}
    );
  }
  @Override
  protected void paintComponent(Graphics graphics) { }

  public static JFrame getFRAME() {
    return FRAME;
  }

  public Model getModel() { return model;  }

  public TilePanel getTilePanel() { return TILE_PANEL; }

  public MapPanel getMapPanel() { return MAP_PANEL; }

  public DeckPanel getDeckPanel() { return DECK_PANEL; }

  public PlayerPanel getPlayerPanel() { return PLAYER_PANEL; }
}
