package edu.neu.ccs.cs5004.eschaton.model.map.cell.celltypes;

import edu.neu.ccs.cs5004.eschaton.model.map.cell.Cell;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.CellPosition;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.contents.Contents;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.contents.EschatonContents;

import javax.swing.text.Position;
import java.awt.*;

public class EschatonCell extends Cell {
  public EschatonCell(CellPosition cellPosition, Point point, Contents contents) {
    super(cellPosition, point, contents);
  }

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



  @Override
  public CellPosition getCellPosition() {
    return cellPosition;
  }


  @Override
  public Color getCellColor(){
    return Color.GREEN;
  }

}
