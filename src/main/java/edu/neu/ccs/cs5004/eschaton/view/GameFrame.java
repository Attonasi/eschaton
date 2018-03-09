package edu.neu.ccs.cs5004.eschaton.view;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import edu.neu.ccs.cs5004.eschaton.model.Model;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.DeckItemInterface;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.actionleader.LeaderActionInterface;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.actions.ActionInterface;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.units.Unit;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.units.UnitInterface;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.village.VillageInterface;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.MainPanel;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.MapPanel;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.PlayerPanel;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.TilePanel;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.DeckPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class GameFrame extends JPanel {

  protected Model model;
  protected static JFrame FRAME;
  protected static Window PANEL;
  protected static TilePanel TILE_PANEL;
  protected static DeckPanel DECK_PANEL;
  protected static MapPanel MAP_PANEL;
  protected static PlayerPanel PLAYER_PANEL;
  protected static MainPanel MAIN_PANEL;


  public GameFrame(Model model, String name, int width, int height) throws IOException {
    this.FRAME = new JFrame(name);
    this.PANEL = new Window(name, width, height);
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

    DECK_PANEL = new DeckPanel();
    FRAME.getContentPane().add(DECK_PANEL.getPanel());

    MAP_PANEL = new MapPanel(model, getDeckPanel(), getTilePanel());
    FRAME.getContentPane().add(MAP_PANEL.getPanel());

    PLAYER_PANEL = new PlayerPanel(model.getPlayers(), DECK_PANEL, 0, this);
    FRAME.getContentPane().add(PLAYER_PANEL.getPanel());

    MAIN_PANEL = new MainPanel();
    FRAME.getContentPane().add(MAIN_PANEL.getPanel());
  }

  public void newPlayerPanel(int currentPlayer){
    PLAYER_PANEL = new PlayerPanel(model.getPlayers(), DECK_PANEL, currentPlayer, this);
    FRAME.getContentPane().add(PLAYER_PANEL.getPanel());
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
}
