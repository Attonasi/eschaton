package edu.neu.ccs.cs5004.eschaton.model.map;

import edu.neu.ccs.cs5004.eschaton.model.map.cell.cellposition.CellPosition;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.panelbuttons.MapPanelCell;

public class Map implements MapInterface {

  /**
   *
   */
  private MapPanelCell[][][] mapGrid = new MapPanelCell[20][20][20];



  /**
   * The map constructor takes the configuration as a parameter and builds out the game
   * map. The size of the map and the origin are pulled from the config class.
   *
   * There will be a variety of map options that are set in the configuration eventually.
   */
  public Map() {
    this.mapGrid = new MapPanelCell[20][20][20];
  }

  /**
   * This method generates a hexagonal map. It creates a cell at each node and supplies that cell
   * with the array indices organizing the map and the Points used to place them on the map window.
   *
   * The Cell types and contents are also generated at this time,
   * @return Cell[][][] hexagonal grid of Cells.
   */
//  private Cell[][][] generateMap(Config config){
//    int[] blockStepX = {X_STEP, 0, -X_STEP, -X_STEP, 0, X_STEP};
//    int[] blockStepY = {Y_STEP_ONE, Y_STEP_TWO, Y_STEP_ONE, -Y_STEP_ONE, -Y_STEP_TWO, -Y_STEP_ONE};
//    Cell[][][] newMapGrid = new Cell[20][20][20];
//
//    newMapGrid[0][0][0] = new EschatonCell(new CellPosition(0, 0, 0),
//        new Point(config.getOrigin().x, config.getOrigin().y),
//        new EschatonContents("Eschaton"),
//        Hexagon.newHexagon(config.getOrigin()));
//
//    for (int distanceFromOrigin =1; distanceFromOrigin < config.getSizeOfMap();
//         distanceFromOrigin++){
//
//      int[] blockXVals = {config.getOrigin().x,
//                          config.getOrigin().x + X_STEP * distanceFromOrigin,
//                          config.getOrigin().x + X_STEP * distanceFromOrigin,
//                          config.getOrigin().x,
//                          config.getOrigin().x - X_STEP * distanceFromOrigin,
//                          config.getOrigin().x - X_STEP * distanceFromOrigin};
//
//      int[] blockYVals = {config.getOrigin().y - Y_STEP_TWO * distanceFromOrigin,
//                          config.getOrigin().y - Y_STEP_ONE * distanceFromOrigin,
//                          config.getOrigin().y + Y_STEP_ONE * distanceFromOrigin,
//                          config.getOrigin().y + Y_STEP_TWO * distanceFromOrigin,
//                          config.getOrigin().y + Y_STEP_ONE * distanceFromOrigin,
//                          config.getOrigin().y - Y_STEP_ONE * distanceFromOrigin};
//
//      for (int block = 1; block < NUMBER_OF_BLOCKS; block ++){
//
//        int blockXOrdinal = blockXVals[block];
//        int blockYOrdinal = blockYVals[block];
//
//        for (int blockSize = 0; blockSize < distanceFromOrigin; blockSize++){
//
//          Point newPoint = new Point(blockXOrdinal + blockStepX[block] * (blockSize + 1),
//              blockYOrdinal + blockStepY[block] * (blockSize + 1));
//
//
//
//          mapGrid [distanceFromOrigin][block][blockSize] =
//              new Plains(new CellPosition(distanceFromOrigin, block, blockSize),
//                         newPoint,
//                         new Wheat("wheat"),
//                         Hexagon.newHexagon(newPoint));
//        }
//      }
//    }
//    return newMapGrid;
//  }

  /**
   * Returns a cell at the position in the 3d array of the map.
   *
   * @param position Position representing which block to find the cell including block, circle
   *                 and clockwise
   * @return Cell at the requested location incl
   */
  @Override
  public MapPanelCell getCellAtPosition(CellPosition position) {
    return mapGrid[position.getBlock()][position.getCircle()][position.getClockwise()];
  }

  public MapPanelCell[][][] getMapGrid() {
    return mapGrid;
  }


}
