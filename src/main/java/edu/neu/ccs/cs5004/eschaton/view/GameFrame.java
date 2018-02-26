package edu.neu.ccs.cs5004.eschaton.view;

import edu.neu.ccs.cs5004.eschaton.model.Model;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.MainPanel;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.MapPanel;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.TilePanel;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.UnitPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class GameFrame extends JPanel {

  protected Model model;
  protected static JFrame FRAME;
  protected static Window PANEL;
//  protected static String TITLE = "Eschaton";
//  protected static Dimension WINDOW_SIZE = new Dimension(1005,605);

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

    MAP_PANEL = new MapPanel(model, getUnitPanel(), getTilePanel());
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
  protected void paintComponent(Graphics graphics) { }

  public Model getModel() { return model;  }

  public TilePanel getTilePanel() { return TILE_PANEL; }

  public MapPanel getMapPanel() { return MAP_PANEL; }

  public UnitPanel getUnitPanel() { return UNIT_PANEL; }
}
