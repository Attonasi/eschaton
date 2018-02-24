package edu.neu.ccs.cs5004.eschaton.model.map.cell;

import edu.neu.ccs.cs5004.eschaton.model.Units.Unit;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.contents.Contents;

public interface
CellInterface {

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

  /**
   * @return Contents the resource return values for the cell.
   */
  public Contents getContents();

  /** A function to facilitate adding a Unit to the units in the cell.
   *
   * @param unit Unit being added to the list
   */
  void addUnit(Unit unit);
}
