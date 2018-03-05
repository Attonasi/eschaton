package edu.neu.ccs.cs5004.eschaton.model.map.cell.celltypes;

import java.awt.*;

import edu.neu.ccs.cs5004.eschaton.model.map.cell.Cell;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.cellposition.CellPosition;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.contents.Contents;

public class Forest extends Cell{

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

  public Forest(CellPosition cellPosition, Point point, Integer special) {
    super(cellPosition, point, special);
  }
  /**
   * Each cell type displays differently and displays special cells differently. For now that is
   * represented by different colored tiles on the map.
   * @return Color that sets the background color of a tile.
   */
  @Override
  public Color getCellColor(){
    return special == 1 ? new Color(15,155,55) :
           special == 2 ? new Color(50,105,0) :
                          new Color(50,205,50);  }

  @Override
  public Contents getContents() {
    return contents;
  }

  /**
   * Each Cell type returns different resources to the player each turn. This function instantiates
   * these values in the content class of the Cell for the appropriate resource combinations amd
   * cell types.
   * @return Contents matching the cell type and special class.
   */
  public Contents createCellContents() {
    return special == 0 ? new Contents(2, 0, 0, 0, 0) :
           special == 1 ? new Contents(2, 2, 0, 0, 0) :
                          new Contents(3, 0, 0, 0, 1);
  }
}
