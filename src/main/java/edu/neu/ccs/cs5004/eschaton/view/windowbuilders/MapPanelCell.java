package edu.neu.ccs.cs5004.eschaton.view.windowbuilders;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.text.Position;

import edu.neu.ccs.cs5004.eschaton.Eschaton;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.Cell;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.CellPosition;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.celltypes.EschatonCell;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.celltypes.Plains;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.contents.Contents;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.contents.EschatonContents;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.contents.Wheat;

import static edu.neu.ccs.cs5004.eschaton.view.windowbuilders.MapPanel.X_OFFSET;
import static edu.neu.ccs.cs5004.eschaton.view.windowbuilders.MapPanel.Y_OFFSET;

public class MapPanelCell implements MapPanelCellIInterface{

  private Cell cell;
  private JButton button;
  private Point point;
  private Integer circle;
  private Integer block;
  private Integer toClockwise;


  public MapPanelCell(Point point,
                      Integer circle, Integer block, Integer toClockwise) {

    this.button = new JButton("");
    this.point = point;
    this.circle = circle;
    this.block = block;
    this.toClockwise = toClockwise;

    this.cell = makeNewCell(new CellPosition(block, circle, toClockwise),
        point, new Wheat("wheat"));

    button.setBounds(point.x-X_OFFSET, point.y-Y_OFFSET, 18, 30);
    button.setBackground(cell.getCellColor());
    button.setContentAreaFilled(true);
    button.setFont(new Font("Arial", Font.PLAIN, 5));

    button.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) {   }

      @Override
      public void mousePressed(MouseEvent mouseEvent) {
        System.out.println("pressed " +circle +", "+block+", "+toClockwise);
        System.out.println(cell.getContents().getContents());
      }

      @Override
      public void mouseReleased(MouseEvent mouseEvent) {   }

      @Override
      public void mouseEntered(MouseEvent mouseEvent) {
//        System.out.println("entered " +circle +", "+block+", "+toClockwise);
      }

      @Override
      public void mouseExited(MouseEvent mouseEvent) {
//        System.out.println("exited " +circle +", "+block+", "+toClockwise);
      }
    });

  }

  private Cell makeNewCell(CellPosition cellPosition, Point point, Contents contents) {

    if (cellPosition.getCircle() < 1){
      return new EschatonCell(cellPosition, point,
          new EschatonContents("Eschaton"));
    }else{
      return new Plains(cellPosition, point, new Wheat("Wheat"));
    }
  }

  /**
   * @return The entire point if that is more convenient.
   */
  @Override
  public Point getPoint() {
    return point;
  }

  /**
   * @return int how far from origin the circle of hexagons this cell is in is.
   */
  @Override
  public int getCircle() {
    return circle;
  }

  /**
   * @return int starting from 12 o'clock the blocks are labeled 1 - 6.
   */
  @Override
  public int getBlock() {
    return block;
  }

  /**
   * @return int moving from the ordinal of the block clockwise until you reach the next block
   */
  @Override
  public int getToClockwise() {
    return toClockwise;
  }

  /**
   * @return JButton the object that has the listeners attached to it.
   */
  @Override
  public JButton getButton() {
    return button;
  }

  /**
   * @return The cell which holds the type, units, upgrades and special resources contained in the
   * MapPanelCell
   */
  @Override
  public Cell getCell() {
    return cell;
  }
}
