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



public class GameFrame extends Window {

  protected Model model;
  protected static TilePanel TILE_PANEL;
  protected static UnitPanel UNIT_PANEL;
  protected static JPanel MAP_PANEL;


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

    TILE_PANEL = new TilePanel();
    FRAME.getContentPane().add(TILE_PANEL.getPanel());

    UNIT_PANEL = new UnitPanel();
    FRAME.getContentPane().add(UNIT_PANEL.getPanel());

    MAP_PANEL = new JPanel();
    MapPanel.makeMapPanel(MAP_PANEL);
    FRAME.getContentPane().add(MAP_PANEL);
  }

  public static void launch() throws IOException {
    PANEL.addMouseListener(PANEL);
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
