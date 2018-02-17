package edu.neu.ccs.cs5004.eschaton.view.objectviews;

import java.awt.*;


import edu.neu.ccs.cs5004.eschaton.model.map.cell.CellPosition;
import edu.neu.ccs.cs5004.eschaton.view.MapFrame;

import static edu.neu.ccs.cs5004.eschaton.config.Config.HEXAGON_SIZE;

public class Hexagon extends MapFrame{

  public static final Integer HEXAGON_SIDES = 6;
  public static final Integer X_ADJUST_ONE = HEXAGON_SIZE;
  public static final int X_ADJUST_TWO = HEXAGON_SIZE * 2;
  public static final int Y_ADJUST = HEXAGON_SIZE * 2;


  public Hexagon(String name, int width, int height) {
    super(name, width, height);
  }

  public static Polygon newHexagon(int xVal, int yVal){
    return new Polygon(Hexagon.buildX( xVal), Hexagon.buildY(yVal), HEXAGON_SIDES);
  }

  private static int[] buildX(int x){
    int[] newX = {x-X_ADJUST_ONE, x+X_ADJUST_ONE, x+X_ADJUST_TWO,
        x+X_ADJUST_ONE, x-X_ADJUST_ONE, x-X_ADJUST_TWO};

    return newX;
  }

  private static int[] buildY(int y){
    int[] newY = {y-Y_ADJUST, y-Y_ADJUST, y, y+Y_ADJUST, y+Y_ADJUST, y};

    return newY;
  }
}
