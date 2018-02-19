package edu.neu.ccs.cs5004.eschaton.view.windowbuilders;

import java.awt.*;

import edu.neu.ccs.cs5004.eschaton.model.Model;
import edu.neu.ccs.cs5004.eschaton.model.map.Map;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.Cell;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.CellPosition;
import edu.neu.ccs.cs5004.eschaton.view.GameFrame;
import edu.neu.ccs.cs5004.eschaton.view.objectmakers.Hexagon;

import static edu.neu.ccs.cs5004.eschaton.config.Config.DEFAULT_SIZE_OF_MAP;
import static edu.neu.ccs.cs5004.eschaton.config.Config.NUMBER_OF_BLOCKS;
import static edu.neu.ccs.cs5004.eschaton.config.Config.X_STEP;
import static edu.neu.ccs.cs5004.eschaton.config.Config.Y_STEP_ONE;
import static edu.neu.ccs.cs5004.eschaton.config.Config.Y_STEP_TWO;

public class MapPrinter extends GameFrame {

  public MapPrinter(Model model, String name, int width, int height) {
    super(model, name, width, height);
  }


//  public static void printMap(Graphics graphics, Map map){
//    for(int dfo = 1; dfo < map.getMapSize(); dfo++){
//      for (int block = 1; block < NUMBER_OF_BLOCKS; block++){
//        for (int blockSize = 0; blockSize < dfo; blockSize++) {
//
//          graphics.setColor(Color.GREEN);
//          graphics.fillPolygon(Hexagon.newHexagon(map.getMapGrid()[dfo][block][blockSize].getPoint()));
//
//        }
//      }
//    }
//  }

  public static void printMap(Graphics graphics, Map map){
    int originX = map.getOrigin().x;
    int originY = map.getOrigin().y;
    int[] blockStepX = {X_STEP, 0, -X_STEP, -X_STEP, 0, X_STEP};
    int[] blockStepY = {Y_STEP_ONE, Y_STEP_TWO, Y_STEP_ONE, -Y_STEP_ONE, -Y_STEP_TWO, -Y_STEP_ONE};
    Color[] colors = {Color.BLACK, Color.BLUE, Color.RED,
        Color.GREEN, Color.CYAN, Color.ORANGE, Color.DARK_GRAY, Color.BLUE};

    for (int distanceFromOrigin= 1; distanceFromOrigin< DEFAULT_SIZE_OF_MAP; distanceFromOrigin++) {
      int[] blockXVals = {originX,
                          originX + X_STEP * distanceFromOrigin,
                          originX + X_STEP * distanceFromOrigin,
                          originX,
                          originX - X_STEP * distanceFromOrigin,
                          originX - X_STEP * distanceFromOrigin};

      int[] blockYVals = {originY - Y_STEP_TWO * distanceFromOrigin,
                          originY - Y_STEP_ONE * distanceFromOrigin,
                          originY + Y_STEP_ONE * distanceFromOrigin,
                          originY + Y_STEP_TWO * distanceFromOrigin,
                          originY + Y_STEP_ONE * distanceFromOrigin,
                          originY - Y_STEP_ONE * distanceFromOrigin};

      for(int block = 0; block < NUMBER_OF_BLOCKS; block ++){
        graphics.setColor(Color.BLACK);
        graphics.fillPolygon(Hexagon.newHexagon(new Point(blockXVals[block], blockYVals[block])));

        for(int blockSize = 0;  blockSize < distanceFromOrigin-1; blockSize++){
          int blockXOrdinal = blockXVals[block];
          int blockYOrdinal = blockYVals[block];
          graphics.setColor(colors[distanceFromOrigin]);
          graphics.fillPolygon(Hexagon.newHexagon(new Point(
               blockXOrdinal + blockStepX[block] * (blockSize + 1),
              blockYOrdinal + blockStepY[block] * (blockSize + 1))));

        }
      }
    }
  }
}
