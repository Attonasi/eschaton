package edu.neu.ccs.cs5004.eschaton.model.map.cell;

import javax.swing.text.Position;

import edu.neu.ccs.cs5004.eschaton.model.map.cell.contents.Contents;

public interface CellInterface {

  /**
   * The Cells are the containers of game information. They are the way we organize and maintain
   * the locations of Player units, terrain, resources, and control values. These are all abstracted
   * out into the class Contents. So a Cell is going to have 4 fields:
   *
   * Related to position all integers
   * - Block
   * - Circle
   * - Clockwise
   * and,
   * - Contents
   */

  public Position getNewCellPostion();

  public Position getPosition();

  public Contents getContents();
}
