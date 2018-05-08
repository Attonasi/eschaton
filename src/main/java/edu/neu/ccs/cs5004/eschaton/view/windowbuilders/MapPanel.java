package edu.neu.ccs.cs5004.eschaton.view.windowbuilders;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;

import edu.neu.ccs.cs5004.eschaton.model.Model;
import edu.neu.ccs.cs5004.eschaton.model.map.Map;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.Cell;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.cellposition.CellPosition;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.panelbuttons.MapPanelCell;

public class MapPanel extends JPanel implements Panel{

  public static final int X_OFFSET = 269;
  public static final int Y_OFFSET = 20;

  private JPanel mapPanel;
  private Model model;
  private Map map;
  private Point origin;
  private DeckPanel deckPanel;
  private TilePanel tilePanel;
  private Integer sizeOfMap;

  public MapPanel(DeckPanel deckPanel, TilePanel tilePanel, Model model) {
    this.deckPanel = deckPanel;
    this.tilePanel = tilePanel;
    this.mapPanel = new JPanel();
    this.model = model;
    this.origin = model.getConfig().getOrigin();
    this.sizeOfMap = model.getConfig().getSizeOfMap();
    buildPanel();
    makeMapButtons();
  }

  /**
   * This is a getter for all of the panels used to build the map window. Each one will have a
   * parent JPanel and this will get it.
   *
   * @return JPanel
   */
  @Override
  public JPanel getPanel() {
    return mapPanel;
  }

  /**
   * Each panel will have it's own build panel method that adds buttons and components to that
   * JPanel object. This will be called by the constructor.
   */

  public void buildPanel() {
    mapPanel.setLayout(null);
    mapPanel.setBackground(Color.DARK_GRAY);
    mapPanel.setBounds(360, 5, 560, 650);
    mapPanel.setVisible(true);
    mapPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
  }

  public void makeMapButtons() {
    makeMapButton(model.getMap().getCellAtPosition(new CellPosition(0,0,
        0)));
    for (int dfo = 1; dfo < this.sizeOfMap; dfo++) {
      for(int block = 0; block < model.getConfig().NUMBER_OF_BLOCKS; block++){
        for(int clockwise = 0; clockwise<dfo; clockwise++){

          makeMapButton(model.getMap().getCellAtPosition(new CellPosition(dfo,block+1,
              clockwise+1)));
        }
      }
    }
  }

  public void makeMapButton(Cell cell){

    mapPanel.add(new MapPanelCell(cell, deckPanel, tilePanel).getButton());
  }


  @Override
  public void actionPerformed(ActionEvent actionEvent) {  }
  @Override
  public void mouseClicked(MouseEvent mouseEvent) {  }
  @Override
  public void mousePressed(MouseEvent mouseEvent) {  }
  @Override
  public void mouseReleased(MouseEvent mouseEvent) {  }
  @Override
  public void mouseEntered(MouseEvent mouseEvent) {  }
  @Override
  public void mouseExited(MouseEvent mouseEvent) {  }
  @Override
  public void mouseDragged(MouseEvent mouseEvent) {  }
  @Override
  public void mouseMoved(MouseEvent mouseEvent) {  }
}
