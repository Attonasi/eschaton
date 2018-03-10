package edu.neu.ccs.cs5004.eschaton.model.map;

import java.awt.*;

import edu.neu.ccs.cs5004.eschaton.config.Config;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.Cell;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.cellposition.CellPosition;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.celltypes.EschatonCell;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.celltypes.Forest;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.celltypes.Hills;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.celltypes.Mountain;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.celltypes.Plains;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.panelbuttons.MapPanelCell;

import static edu.neu.ccs.cs5004.eschaton.config.Config.NUMBER_OF_BLOCKS;
import static edu.neu.ccs.cs5004.eschaton.config.Config.ORIGIN;
import static edu.neu.ccs.cs5004.eschaton.config.Config.X_STEP;
import static edu.neu.ccs.cs5004.eschaton.config.Config.Y_STEP_ONE;
import static edu.neu.ccs.cs5004.eschaton.config.Config.Y_STEP_TWO;
import static edu.neu.ccs.cs5004.eschaton.config.Config.getRandomNumber;

public class Map implements MapInterface {

  private MapPanelCell[][][] mapGrid = new MapPanelCell[20][20][20];
  private Cell[][][] cellGrid = new Cell[20][20][20];
  private Config config;
  private Point origin;

  /**
   * The map constructor takes the configuration as a parameter and builds out the game
   * map. The size of the map and the origin are pulled from the config class.
   *
   * There will be a variety of map options that are set in the configuration eventually.
   */
  public Map(Config config) {

    this.mapGrid = new MapPanelCell[20][20][20];
    this.cellGrid= new Cell[20][20][20];
    this.config = config;
    this.origin = config.getOrigin();
    this.cellGrid = generateMap();
    System.out.println(cellGrid);
  }

  /**
   * This method generates a hexagonal map. It creates a cell at each node and supplies that cell
   * with the array indices organizing the map and the Points used to place them on the map window.
   *
   * The Cell types and contents are also generated at this time,
   * @return Cell[][][] hexagonal grid of Cells.
   */
  private Cell[][][] generateMap(){
    int[] blockStepX = {X_STEP, 0, -X_STEP, -X_STEP, 0, X_STEP};
    int[] blockStepY = {Y_STEP_ONE, Y_STEP_TWO, Y_STEP_ONE, -Y_STEP_ONE, -Y_STEP_TWO, -Y_STEP_ONE};
    int blockSpecialValue = 0;

    Cell[][][] newMapGrid = new Cell[20][20][20];

    newMapGrid[0][0][0] = new EschatonCell(new CellPosition(0, 0, 0),
        new Point(origin.x, origin.y), blockSpecialValue);

    for (int distanceFromOrigin = 1; distanceFromOrigin < config.getSizeOfMap();
         distanceFromOrigin++){

      int[] blockXVals = {origin.x,
                          origin.x + X_STEP * distanceFromOrigin,
                          origin.x + X_STEP * distanceFromOrigin,
                          origin.x,
                          origin.x - X_STEP * distanceFromOrigin,
                          origin.x - X_STEP * distanceFromOrigin};

      int[] blockYVals = {origin.y - Y_STEP_TWO * distanceFromOrigin,
                          origin.y - Y_STEP_ONE * distanceFromOrigin,
                          origin.y + Y_STEP_ONE * distanceFromOrigin,
                          origin.y + Y_STEP_TWO * distanceFromOrigin,
                          origin.y + Y_STEP_ONE * distanceFromOrigin,
                          origin.y - Y_STEP_ONE * distanceFromOrigin};

      blockSpecialValue = getRandomNumber(distanceFromOrigin, 0, 1);


      for (int block = 1; block < NUMBER_OF_BLOCKS; block ++){

        int blockXOrdinal = blockXVals[block];
        int blockYOrdinal = blockYVals[block];

        for (int blockSize = 0; blockSize < distanceFromOrigin; blockSize++){

          Point newPoint = new Point(blockXOrdinal + blockStepX[block] * (blockSize + 1),
              blockYOrdinal + blockStepY[block] * (blockSize + 1));

          cellGrid [distanceFromOrigin][block][blockSize] = makeNewCell(
              new CellPosition(block, distanceFromOrigin, blockSize),
              newPoint, blockSpecialValue);
        }
      }
    }
    return newMapGrid;
  }

  private Cell makeNewCell(CellPosition cellPosition, Point point, Integer special) {
    int randomCell = getRandomNumber(8, 1, 1);
    if (cellPosition.getCircle() < 1){
      return new EschatonCell(cellPosition, point, special);
    }else if (randomCell == 1){
      return new Mountain(cellPosition, point, special);
    }else if (randomCell < 3 ){
      return new Hills(cellPosition, point, special);
    }else if (randomCell < 5){
      return new Forest(cellPosition, point, special);
    }else{
      return new Plains(cellPosition, point,special);
    }
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
    return cellGrid[position.getBlock()][position.getCircle()][position.getClockwise()];
  }

  public MapPanelCell[][][] getMapGrid() {
    return mapGrid;
  }
  public Cell[][][] getCellGrid() {
    return cellGrid;
  }



}
