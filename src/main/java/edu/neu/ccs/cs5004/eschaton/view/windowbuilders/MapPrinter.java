package edu.neu.ccs.cs5004.eschaton.view.windowbuilders;

import java.awt.*;

import edu.neu.ccs.cs5004.eschaton.view.GameFrame;
import edu.neu.ccs.cs5004.eschaton.view.objectmakers.Hexagon;

import static edu.neu.ccs.cs5004.eschaton.config.Config.DEFAULT_SIZE_OF_MAP;
import static edu.neu.ccs.cs5004.eschaton.config.Config.HEXAGON_SIZE;
import static edu.neu.ccs.cs5004.eschaton.config.Config.NUMBER_OF_BLOCKS;

public class MapPrinter extends GameFrame {

  public static final Integer X_STEP = HEXAGON_SIZE * 3;
  public static final int Y_STEP_ONE = HEXAGON_SIZE * 2;
  public static final int Y_STEP_TWO = HEXAGON_SIZE * 4;

  public MapPrinter(String name, int width, int height) {
    super(name, width, height);
  }

  public static void printMap(Graphics graphics, Point point){
    int originX = point.x;
    int originY = point.y;
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
