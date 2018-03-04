package edu.neu.ccs.cs5004.eschaton.model.map.cell.celltypes;

import java.awt.*;

import edu.neu.ccs.cs5004.eschaton.model.map.cell.Cell;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.CellPosition;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.contents.Contents;

public class EschatonCell extends Cell {

  /**
   * The Cells are the containers of game information. They are the way we organize and maintain
   * the locations of Player units, terrain, resources, and control values. These are all abstracted
   * out into the class Contents. So a Cell is going to have 4 fields:
   * <p>
   * Related to position all integers
   * - Block
   * - Circle
   * - Clockwise
   * and,
   * - Contents
   */
  public EschatonCell(CellPosition cellPosition, Point point, Integer special) {
    super(cellPosition, point, special);
  }

  /**
   * Each Cell type returns different resources to the player each turn. This function instantiates
   * these values in the content class of the Cell for the appropriate resource combinations amd
   * cell types.
   * @return Contents matching the cell type and special class.
   */
  @Override
  protected Contents createCellContents() {
    return new Contents(0,0,0,0,0);
  }


  /**
   *
   * @return CellPosition of 0, 0, 0.
   */
  @Override
  public CellPosition getCellPosition() {
    return cellPosition;
  }

  /**
   * Each cell type displays differently and displays special cells differently. For now that is
   * represented by different colored tiles on the map.
   * @return Color that sets the background color of a tile.
   */
  @Override
  public Color getCellColor(){
    return Color.BLACK;
  }

}
