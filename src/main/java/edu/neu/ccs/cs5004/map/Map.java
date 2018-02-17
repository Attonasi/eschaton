package edu.neu.ccs.cs5004.map;

import java.util.Arrays;

import javax.swing.text.Position;

import edu.neu.ccs.cs5004.map.cell.Cell;
import edu.neu.ccs.cs5004.map.cell.CellPosition;

public class Map implements MapInterface {

  private Cell[][][] mapGrid;

  public Map(Cell[][][] mapGrid) {
    this.mapGrid = mapGrid;
  }

  /**
   * Returns a cell at the position in the 3d array of the map.
   *
   * @param position Position representing which block to find the cell including block, circle
   *                 and clockwise
   * @return Cell at the requested location incl
   */
  @Override
  public Cell getCellAtPosition(CellPosition position) {
    return mapGrid[position.getBlock()][position.getCircle()][position.getClockwise()];
  }

  public Cell[][][] getMapGrid() {
    return mapGrid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Map map = (Map) o;
    return Arrays.equals(mapGrid, map.mapGrid);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(mapGrid);
  }

  @Override
  public String toString() {
    return "Map{" +
        "mapGrid=" + Arrays.toString(mapGrid) +
        '}';
  }
}
