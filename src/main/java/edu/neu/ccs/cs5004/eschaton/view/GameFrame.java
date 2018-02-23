package edu.neu.ccs.cs5004.eschaton.view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import edu.neu.ccs.cs5004.eschaton.Eschaton;
import edu.neu.ccs.cs5004.eschaton.config.Config;
import edu.neu.ccs.cs5004.eschaton.model.Model;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.*;

import static edu.neu.ccs.cs5004.eschaton.config.Config.SCREEN_HEIGHT;
import static edu.neu.ccs.cs5004.eschaton.config.Config.SCREEN_WIDTH;


public class GameFrame extends JPanel {

  protected Model model;
  protected static JFrame FRAME;
  protected static Window PANEL; // JPanel that is also a lisener
  protected static String TITLE = "Eschaton";
  protected static Dimension WINDOW_SIZE = new Dimension(1005,605);

  protected static TilePanel TILE_PANEL;
  protected static UnitPanel UNIT_PANEL;
  protected static MapPanel MAP_PANEL;
  protected static MainPanel MAIN_PANEL;


  public GameFrame(Model model, String name, int width, int height) throws IOException {
    this.FRAME = new JFrame(name);
    this.PANEL = new Window(name, width, height);
    this.model = model;
    createAndShowGUI(model);
  }

  private void createAndShowGUI(Model model) throws IOException {
    FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    PANEL.setLayout(null);
    FRAME.getContentPane().add(PANEL);
    FRAME.pack();
    FRAME.setVisible(true);
    FRAME.setResizable(true);

    TILE_PANEL = new TilePanel();
    FRAME.getContentPane().add(TILE_PANEL.getPanel());

    UNIT_PANEL = new UnitPanel();
    FRAME.getContentPane().add(UNIT_PANEL.getPanel());

    MAP_PANEL = new MapPanel(model);
    FRAME.getContentPane().add(MAP_PANEL.getPanel());

    MAIN_PANEL = new MainPanel();
    FRAME.getContentPane().add(MAIN_PANEL.getPanel());
  }

  public void launch(Model model) throws IOException {

    javax.swing.SwingUtilities.invokeLater(
        new Runnable(){ public void run(){
          try {
            createAndShowGUI(model);
          } catch (IOException e) {
            e.printStackTrace();
          }
        } }
    );
  }
  @Override
  protected void paintComponent(Graphics graphics) {
//    MapPrinter.printMap(graphics, model.getMap());
  }

  public Model getModel() {
    return model;
  }
//
//  public static void main(String[] args) throws IOException {
//    Config config = new Config();
//
//    Model model = new Model(config);
//
//       GameFrame gf = new GameFrame(model, config.GAME_NAME, SCREEN_WIDTH, SCREEN_HEIGHT);
//       launch(model);
//  }
}
