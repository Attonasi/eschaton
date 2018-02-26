package edu.neu.ccs.cs5004.eschaton.model.map.cell.celltypes;

import java.awt.*;

import edu.neu.ccs.cs5004.eschaton.model.map.cell.Cell;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.CellPosition;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.contents.Contents;

public class Hills extends Cell{
  /**
   * The Cells are the containers of game information. They are the way we organize and maintain
   * the locations of Player units, terrain, resources, and control values. These are all abstracted
   * out into the class Contents. So a Cell is going to have 3 fields:
   *
   * Related to cellPosition all integers
   * - Block
   * - Circle
   * - Clockwise
   *
   * Point consiting of
   * - x int graph position
   * - y int graph position
   * and,
   * - Contents
   */

  public Hills(CellPosition cellPosition, Point point, Integer special) {
    super(cellPosition, point, special);
  }

  @Override
  public Color getCellColor(){
    return special == 1 ? new Color(255,155,105) :
           special == 2 ? new Color(200,255,100) :
                          new Color(150,150,100);
  }

  @Override
  public Contents getContents() {
    return contents;
  }

  public Contents createCellContents() {
    return special == 0 ? new Contents(0, 1, 1, 0, 0) :
           special == 1 ? new Contents(0, 0, 2, 1, 1) :
                          new Contents(0, 2, 0, 0, 2);
  }
}
