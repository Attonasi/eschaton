package edu.neu.ccs.cs5004.eschaton.model.map;

import java.awt.*;
import java.util.Arrays;

import edu.neu.ccs.cs5004.eschaton.config.Config;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.Cell;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.CellPosition;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.celltypes.EschatonCell;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.celltypes.Plains;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.contents.Contents;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.contents.EschatonContents;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.contents.Wheat;

import static edu.neu.ccs.cs5004.eschaton.config.Config.NUMBER_OF_BLOCKS;
import static edu.neu.ccs.cs5004.eschaton.config.Config.X_STEP;
import static edu.neu.ccs.cs5004.eschaton.config.Config.Y_STEP_ONE;
import static edu.neu.ccs.cs5004.eschaton.config.Config.Y_STEP_TWO;

public class Map implements MapInterface {

  /**
   *
   */
  private Cell[][][] mapGrid = new Cell[20][20][20];
  private Integer mapSize;
  private Point origin;


  /**
   * The map constructor takes the configuration as a parameter and builds out the game
   * map. The size of the map and the origin are pulled from the config class.
   *
   * There will be a variety of map options that are set in the configuration eventually.
   *
   * @param config Config holds all of hte default and preset values to start a game.
   */
  public Map(Config config) {
    this.mapGrid = generateMap(config);
    this.mapSize = config.getSizeOfMap();
    this.origin = config.getOrigin();
  }

  /**
   * This method generates a hexagonal map. It creates a cell at each node and supplies that cell
   * with the array indices organizing the map and the Points used to place them on the map window.
   *
   * The Cell types and contents are also generated at this time,
   * @return Cell[][][] hexagonal grid of Cells.
   */
  private Cell[][][] generateMap(Config config){
    int[] blockStepX = {X_STEP, 0, -X_STEP, -X_STEP, 0, X_STEP};
    int[] blockStepY = {Y_STEP_ONE, Y_STEP_TWO, Y_STEP_ONE, -Y_STEP_ONE, -Y_STEP_TWO, -Y_STEP_ONE};
    Cell[][][] newMapGrid = new Cell[20][20][20];

    newMapGrid[0][0][0] = new EschatonCell(new CellPosition(0, 0, 0),
        new Point(config.getOrigin().x, config.getOrigin().y),
        new EschatonContents("Eschaton"));

    for (int distanceFromOrigin =1; distanceFromOrigin < config.getSizeOfMap();
         distanceFromOrigin++){

      int[] blockXVals = {config.getOrigin().x,
                          config.getOrigin().x + X_STEP * distanceFromOrigin,
                          config.getOrigin().x + X_STEP * distanceFromOrigin,
                          config.getOrigin().x,
                          config.getOrigin().x - X_STEP * distanceFromOrigin,
                          config.getOrigin().x - X_STEP * distanceFromOrigin};

      int[] blockYVals = {config.getOrigin().y - Y_STEP_TWO * distanceFromOrigin,
                          config.getOrigin().y - Y_STEP_ONE * distanceFromOrigin,
                          config.getOrigin().y + Y_STEP_ONE * distanceFromOrigin,
                          config.getOrigin().y + Y_STEP_TWO * distanceFromOrigin,
                          config.getOrigin().y + Y_STEP_ONE * distanceFromOrigin,
                          config.getOrigin().y - Y_STEP_ONE * distanceFromOrigin};

      for (int block = 1; block < NUMBER_OF_BLOCKS; block ++){

        int blockXOrdinal = blockXVals[block];
        int blockYOrdinal = blockYVals[block];

        for (int blockSize = 0; blockSize < distanceFromOrigin; blockSize++){

          mapGrid [distanceFromOrigin][block][blockSize] =
              new Plains(new CellPosition(distanceFromOrigin, block, blockSize),
                         new Point(blockXOrdinal + blockStepX[block] * (blockSize + 1),
                                  blockYOrdinal + blockStepY[block] * (blockSize + 1)),
                         new Wheat("wheat"));
        }
      }
    }
    return newMapGrid;
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

  public Integer getMapSize() {
    return mapSize;
  }

  public Point getOrigin() {
    return origin;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Map map = (Map) o;

    if (!Arrays.deepEquals(mapGrid, map.mapGrid)) return false;
    if (!mapSize.equals(map.mapSize)) return false;
    return origin.equals(map.origin);
  }

  @Override
  public int hashCode() {
    int result = Arrays.deepHashCode(mapGrid);
    result = 31 * result + mapSize.hashCode();
    result = 31 * result + origin.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "Map{" +
        "mapGrid=" + Arrays.toString(mapGrid) +
        ", mapSize=" + mapSize +
        ", origin=" + origin +
        '}';
  }
}
