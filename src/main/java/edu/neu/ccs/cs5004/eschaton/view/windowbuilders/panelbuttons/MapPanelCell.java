package edu.neu.ccs.cs5004.eschaton.view.windowbuilders.panelbuttons;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import edu.neu.ccs.cs5004.eschaton.model.map.cell.Cell;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.cellposition.CellPosition;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.celltypes.EschatonCell;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.celltypes.Forest;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.celltypes.Hills;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.celltypes.Mountain;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.celltypes.Plains;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.TilePanel;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.DeckPanel;

import static edu.neu.ccs.cs5004.eschaton.config.Config.getRandomNumber;
import static edu.neu.ccs.cs5004.eschaton.view.windowbuilders.MapPanel.X_OFFSET;
import static edu.neu.ccs.cs5004.eschaton.view.windowbuilders.MapPanel.Y_OFFSET;

public class MapPanelCell implements MapPanelCellIInterface{

  private Cell cell;
  private JButton button;
  private Point point;
  private Integer circle;
  private Integer block;
  private Integer toClockwise;
  private Integer special;
  private DeckPanel deckPanel;
  private TilePanel tilePanel;


  public MapPanelCell(Point point,
                      Integer circle, Integer block, Integer toClockwise, Integer special,
                      DeckPanel deckPanel, TilePanel tilePanel) {

    this.button = new JButton("x");
    this.point = point;
    this.circle = circle;
    this.block = block;
    this.toClockwise = toClockwise;
    this.deckPanel = deckPanel;
    this.tilePanel = tilePanel;

    this.cell = makeNewCell(new CellPosition(block, circle, toClockwise),
        point, special);



    button.setBounds(point.x-X_OFFSET, point.y-Y_OFFSET, 30, 30);
    button.setBackground(cell.getCellColor());
    button.setContentAreaFilled(true);
    button.setFont(new Font("Arial", Font.PLAIN, 5));

    button.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) {   }

      @Override
      public void mousePressed(MouseEvent mouseEvent) {
        tilePanel.getWoodField().setText(String.valueOf(cell.getContents().getWood()));
        tilePanel.getFoodField().setText(String.valueOf(cell.getContents().getFood()));
        tilePanel.getIronField().setText(String.valueOf(cell.getContents().getIron()));
        tilePanel.getStoneField().setText(String.valueOf(cell.getContents().getStone()));
        tilePanel.getGoldField().setText(String.valueOf(cell.getContents().getGold()));
        tilePanel.getCircleField().setText(circle.toString());
        tilePanel.getBlockField().setText(block.toString());
        tilePanel.getToClockwiseField().setText(toClockwise.toString());
        deckPanel.getCircleMiddle().setText(String.valueOf(circle));
        deckPanel.getBlockMiddle().setText(String.valueOf(block));
        deckPanel.getToClockwiseMiddle().setText(String.valueOf(toClockwise));
        deckPanel.getCircleBottom().setText(String.valueOf(circle));
        deckPanel.getBlockBottom().setText(String.valueOf(block));
        deckPanel.getToClockwiseBottom().setText(String.valueOf(toClockwise));
      }
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {  }
    @Override
    public void mouseEntered(MouseEvent mouseEvent) { }
    @Override
    public void mouseExited(MouseEvent mouseEvent) { }
  });

  }

  private Cell makeNewCell(CellPosition cellPosition, Point point, Integer special) {
    int randomCell = getRandomNumber(8, 1, 1);
    if (cellPosition.getCircle() < 1){
      return new EschatonCell(cellPosition, point, special);
    }else if (randomCell == 1){
      return new Mountain(cellPosition, point, special);
    }else if (randomCell < 3 ){
      return new Hills(cellPosition, point, special);
    }else if (randomCell < 5){
      return new Forest(cellPosition, point, special);
    }else{
      return new Plains(cellPosition, point,special);
    }
  }

  /**
   * @return The entire point if that is more convenient.
   */
  @Override
  public Point getPoint() { return point; }

  /**
   * @return int how far from origin the circle of hexagons this cell is in is.
   */
  @Override
  public int getCircle() { return circle; }

  /**
   * @return int starting from 12 o'clock the blocks are labeled 1 - 6.
   */
  @Override
  public int getBlock() { return block; }

  /**
   * @return int moving from the ordinal of the block clockwise until you reach the next block
   */
  @Override
  public int getToClockwise() { return toClockwise; }

  /**
   * @return JButton the object that has the listeners attached to it.
   */
  @Override
  public JButton getButton() { return button; }


  /**
   * @return The cell which holds the type, units, upgrades and special resources contained in the
   * MapPanelCell
   */
  @Override
  public Cell getCell() { return cell; }

  public void setDeckPanel(DeckPanel newPanel){

  }
}
