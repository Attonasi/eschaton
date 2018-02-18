package edu.neu.ccs.cs5004.eschaton.model.map.cell;


import java.awt.*;

import edu.neu.ccs.cs5004.eschaton.model.map.cell.contents.Contents;

public abstract class Cell implements CellInterface{

  /**
   * There are 6 types of concrete Cells, BlockOne, BlockTwo, BlockThree, BlockFour, BlockFive, and
   * BlockSix.
   */
  private CellPosition cellPosition;
  private Point point;
  private Contents contents;


  public Cell(CellPosition cellPosition, Point point, Contents contents) {
    this.cellPosition = cellPosition;
    this.point = point;
    this.contents = contents;
  }

  public CellPosition getCellPosition() {
    return cellPosition;
  }

  public Point getPoint() {
    return point;
  }

  @Override
  public Contents getContents() {
    return contents;
  }
}
