package edu.neu.ccs.cs5004.eschaton.view.windowbuilders;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;

import edu.neu.ccs.cs5004.eschaton.model.Model;
import edu.neu.ccs.cs5004.eschaton.model.map.Map;
import edu.neu.ccs.cs5004.eschaton.view.GameFrame;

import static edu.neu.ccs.cs5004.eschaton.config.Config.DEFAULT_SIZE_OF_MAP;
import static edu.neu.ccs.cs5004.eschaton.config.Config.NUMBER_OF_BLOCKS;
import static edu.neu.ccs.cs5004.eschaton.config.Config.X_STEP;
import static edu.neu.ccs.cs5004.eschaton.config.Config.Y_STEP_ONE;
import static edu.neu.ccs.cs5004.eschaton.config.Config.Y_STEP_TWO;

public class MapPanel extends JPanel implements Panel{

  public static final int X_OFFSET = 269;
  public static final int Y_OFFSET = 20;

  private JPanel mapPanel;
  private Model model;
  private Map map;
  private Point origin;
  private JButton originButton;
  private UnitPanel unitPanel;
  private TilePanel tilePanel;

  public MapPanel(Model model, UnitPanel unitPanel, TilePanel tilePanel) {
    this.unitPanel = unitPanel;
    this.tilePanel = tilePanel;
    this.mapPanel = new JPanel();
    this.model = model;
    this.map = model.getMap();
    this.origin = model.getConfig().getOrigin();

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
  @Override
  public void buildPanel() {
    mapPanel.setLayout(null);
    mapPanel.setBackground(Color.DARK_GRAY);
    mapPanel.setBounds(260, 5, 700, 605);
    mapPanel.setVisible(true);
    Border blackline = BorderFactory.createLineBorder(Color.RED);
    mapPanel.setBorder(blackline);
  }

  public void makeMapButtons(){
    int originX = origin.x;
    int originY = origin.y;
    int[] blockStepX = {X_STEP, 0, -X_STEP, -X_STEP, 0, X_STEP};
    int[] blockStepY = {Y_STEP_ONE, Y_STEP_TWO, Y_STEP_ONE, -Y_STEP_ONE, -Y_STEP_TWO, -Y_STEP_ONE};

    for (int dFromOrigin= 0; dFromOrigin< DEFAULT_SIZE_OF_MAP; dFromOrigin++) {
      int[] blockXVals = {originX,
          originX + X_STEP * dFromOrigin,
          originX + X_STEP * dFromOrigin,
          originX,
          originX - X_STEP * dFromOrigin,
          originX - X_STEP * dFromOrigin};

      int[] blockYVals = {originY - Y_STEP_TWO * dFromOrigin,
          originY - Y_STEP_ONE * dFromOrigin,
          originY + Y_STEP_ONE * dFromOrigin,
          originY + Y_STEP_TWO * dFromOrigin,
          originY + Y_STEP_ONE * dFromOrigin,
          originY - Y_STEP_ONE * dFromOrigin};

      for(int block = 0; block < NUMBER_OF_BLOCKS; block ++){
        MapPanelCell newCell = new MapPanelCell(new Point(blockXVals[block], blockYVals[block]),
            dFromOrigin, block, 0, unitPanel, tilePanel);

        map.getMapGrid()[dFromOrigin][block][0] = newCell;
        mapPanel.add(newCell.getButton());

        for(int blockSize = 0;  blockSize < dFromOrigin-1; blockSize++){
          int blockXOrdinal = blockXVals[block];
          int blockYOrdinal = blockYVals[block];

          MapPanelCell newCellCW = new MapPanelCell(new Point(
              blockXOrdinal + blockStepX[block] * (blockSize + 1),
              blockYOrdinal + blockStepY[block] * (blockSize + 1)),
              dFromOrigin, block, blockSize + 1, unitPanel, tilePanel);

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
