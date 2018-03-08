package edu.neu.ccs.cs5004.eschaton.view.windowbuilders;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;

import edu.neu.ccs.cs5004.eschaton.model.Model;
import edu.neu.ccs.cs5004.eschaton.model.map.Map;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.panelbuttons.MapPanelCell;

import static edu.neu.ccs.cs5004.eschaton.config.Config.*;

public class MapPanel extends JPanel implements Panel{

  public static final int X_OFFSET = 269;
  public static final int Y_OFFSET = 20;

  private JPanel mapPanel;
  private Model model;
  private Map map;
  private Point origin;
  private UnitPanel unitPanel;
  private TilePanel tilePanel;
  private Integer sizeOfMap;

  public MapPanel(Model model, UnitPanel unitPanel, TilePanel tilePanel) {
    this.unitPanel = unitPanel;
    this.tilePanel = tilePanel;
    this.mapPanel = new JPanel();
    this.model = model;
    this.map = model.getMap();
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
    mapPanel.setBounds(360, 5, 570, 650);
    mapPanel.setVisible(true);
    Border blackline = BorderFactory.createLineBorder(Color.RED);
    mapPanel.setBorder(blackline);
  }

public void makeMapButtons(){
  int[] blockStepX = {X_STEP, 0, -X_STEP, -X_STEP, 0, X_STEP};
  int[] blockStepY = {Y_STEP_ONE, Y_STEP_TWO, Y_STEP_ONE, -Y_STEP_ONE, -Y_STEP_TWO, -Y_STEP_ONE};
  int blockSpecialValue = 0;
  int cellSpecial = 0;

  map.getMapGrid()[0][0][0] = new MapPanelCell(new Point(origin.x, origin.y),
      0, 0, 0, 0, unitPanel, tilePanel);
  mapPanel.add(map.getMapGrid()[0][0][0].getButton());

  for (int dFromOrigin= 0; dFromOrigin < sizeOfMap; dFromOrigin++) {
    int[] blockXVals = {origin.x,
        origin.x + X_STEP * dFromOrigin,
        origin.x + X_STEP * dFromOrigin,
        origin.x,
        origin.x - X_STEP * dFromOrigin,
        origin.x - X_STEP * dFromOrigin};

    int[] blockYVals = {origin.y - Y_STEP_TWO * dFromOrigin,
        origin.y - Y_STEP_ONE * dFromOrigin,
        origin.y + Y_STEP_ONE * dFromOrigin,
        origin.y + Y_STEP_TWO * dFromOrigin,
        origin.y + Y_STEP_ONE * dFromOrigin,
        origin.y - Y_STEP_ONE * dFromOrigin};

    blockSpecialValue = getRandomNumber(dFromOrigin, 1, 1) - 1;

    for(int block = 0; block < NUMBER_OF_BLOCKS; block ++){
      int blockXOrdinal = blockXVals[block];
      int blockYOrdinal = blockYVals[block];

      for(int blockSize = 0;  blockSize < dFromOrigin; blockSize++){

        if(blockSpecialValue == blockSize){
          cellSpecial = getRandomNumber(2, 1, 1);
        }else {
          cellSpecial = 0;
        }
        MapPanelCell newCellCW = new MapPanelCell(new Point(
            blockXOrdinal + blockStepX[block] * (blockSize),
            blockYOrdinal + blockStepY[block] * (blockSize)),
            dFromOrigin, block + 1, blockSize + 1, cellSpecial, unitPanel, tilePanel);

        map.getMapGrid()[dFromOrigin][block][blockSize+1] = newCellCW;
        mapPanel.add(newCellCW.getButton());
      }
    }
  }
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
