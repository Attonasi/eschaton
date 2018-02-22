package edu.neu.ccs.cs5004.eschaton.view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import edu.neu.ccs.cs5004.eschaton.model.Model;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.MapPanel;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.MapPrinter;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.TilePanel;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.UnitPanel;

import static edu.neu.ccs.cs5004.eschaton.config.Config.ORIGIN;

public class GameFrame extends Window {

  protected Model model;

  public GameFrame(Model model, String name, int width, int height) {
    super(name, width, height);
    this.model = model;
  }

  private static void createAndShowGUI() throws IOException {
    FRAME = new JFrame(TITLE);
    FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    FRAME.addKeyListener(PANEL); // keyListener added to frame
    FRAME.getContentPane().add(PANEL);
    FRAME.pack();
    FRAME.setVisible(true);
    FRAME.setResizable(false);
    PANEL.setBackground(Color.BLACK);

    TILE_PANEL = new JPanel();
    TilePanel.makeTilePanel(TILE_PANEL);
    FRAME.getContentPane().add(TILE_PANEL);

    UNIT_PANEL = new JPanel();
    UnitPanel.makeUnitPanel(UNIT_PANEL);
    FRAME.getContentPane().add(UNIT_PANEL);

    MAP_PANEL = new JPanel();
    MapPanel.makeMapPanel(MAP_PANEL);
    FRAME.getContentPane().add(MAP_PANEL);
  }

  public static void launch() throws IOException {
    // add in the listeners first
    PANEL.addMouseListener(PANEL); // mouseListeners added to panel
    PANEL.addMouseMotionListener(PANEL);

    javax.swing.SwingUtilities.invokeLater(
        new Runnable(){ public void run(){
          try {
            createAndShowGUI();
          } catch (IOException e) {
            e.printStackTrace();
          }
        } }
    );
  }
  @Override
  protected void paintComponent(Graphics graphics) {

    MapPrinter.printMap(graphics, model.getMap());

  }
}
