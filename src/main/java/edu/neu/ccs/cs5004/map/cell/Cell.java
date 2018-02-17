package edu.neu.ccs.cs5004.map.cell;


import edu.neu.ccs.cs5004.map.cell.contents.Contents;

public abstract class Cell implements CellInterface{

  /**
   * There are 6 types of concrete Cells, BlockOne, BlockTwo, BlockThree, BlockFour, BlockFive, and
   * BlockSix.
   */
  private CellPosition cellPosition;
  private Contents contents;


  public Cell(CellPosition cellPosition, Contents contents) {
    this.cellPosition = cellPosition;
    this.contents = contents;
  }

}
