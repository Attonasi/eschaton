package edu.neu.ccs.cs5004.eschaton.model.map.cell;


import java.awt.*;

import edu.neu.ccs.cs5004.eschaton.model.map.cell.contents.Contents;

public abstract class Cell implements CellInterface{

  /**
   * There are 6 types of concrete Cells, BlockOne, BlockTwo, BlockThree, BlockFour, BlockFive, and
   * BlockSix.
   */
  protected CellPosition cellPosition;
  protected Point point;
  protected Contents contents;
  protected Polygon hexagon;


  public Cell(CellPosition cellPosition, Point point, Contents contents, Polygon hexagon) {
    this.cellPosition = cellPosition;
    this.point = point;
    this.contents = contents;
    this.hexagon = hexagon;
  }

  public CellPosition getCellPosition() {
    return cellPosition;
  }

  public Point getPoint() {
    return point;
  }

  public Color getCellColor(){
    return Color.GREEN;
  }

  @Override
  public Contents getContents() {
    return contents;
  }

  public Polygon getHexagon() {
    return hexagon;
  }
}
