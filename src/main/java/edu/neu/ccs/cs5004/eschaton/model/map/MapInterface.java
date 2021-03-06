package edu.neu.ccs.cs5004.eschaton.model.map;

import edu.neu.ccs.cs5004.eschaton.model.map.cell.Cell;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.cellposition.CellPosition;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.panelbuttons.MapPanelCell;

public interface MapInterface {

  /** A map in the game of Eschaton is hexagonal. The grid is based off of 3 values which are all
   *  represented by Integers. The map starts from 0 0 0 or origin which is the Hexagon at the
   *  center of the map. The hexagons are aligned with the flat side up/down. The grid is based off
   *  concentric circles of hexagons expanding from Origin. These values are:
   *
   * -  Block   If you go straight up from Origin you are in Block 1. If you go up-right you are in
   *            Block 2. Down-right block 3, down block 4, down-left block 5, and up left block 6.
   *            Each block extends to the edge of the map and is responsible for 1/6th of the tiles.
   *
   * - Circle   As you move further from Origin circle increases. If you go straight up from Origin
   *            block increases by one. i.e. 1 1 0. If you go straight down from Origin you are in
   *            block 4 1 0. If you go down 3 Cells from Origin you are in 4 3 0 etc. A Cell in
   *            Block 3 with a Circle value of 5 is just as far from Origin as a Cell in Block 6
   *            with a value of 5.
   *
   * -Clockwise Each block represents 1/6th of the map. The Clockwise Cell with the value of 0 for
   *            each block extends in a straight line from Origin to the edge of the map. To cover
   *            the Cells in each block you need to move from those ordinals one way or the other.
   *            I chose right. In the Circle value of 2 for every block there is 1 Cell between the
   *            Block ordinal. 1 2 0 and 2 2 0 have one Cell between them in circle two. So you move
   *            Clockwise 1 Cell for a value of 1 2 1. Clockwise will always have a value of 0 to
   *            Circle - 1 inclusive.
   */

  /**
   * Returns a cell at the position in the 3d array of the map.
   * @param position Position representing which block to find the cell including block, circle
   *                 and clockwise
   * @return Cell at the requested location incl
   */
  public Cell getCellAtPosition(CellPosition position);

}
