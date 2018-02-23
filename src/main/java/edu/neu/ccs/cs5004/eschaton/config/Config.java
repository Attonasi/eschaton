package edu.neu.ccs.cs5004.eschaton.config;

import java.awt.*;

/**
 * When the person creating the game sets the parameters of the game they are stored here. There are
 * of course default values. Everything here is self documenting.
 */
public class Config {

  public static final String GAME_NAME = "Eschaton";
  public static final Integer DEFAULT_NUMBER_OF_PLAYERS = 2;
  public static final Integer DEFAULT_SIZE_OF_MAP = 9;
  public static final Boolean DEFAULT_FOG_VALUE = false;
  public static final Integer SCREEN_HEIGHT = 610;
  public static final Integer SCREEN_WIDTH = 960;
  public static final Integer HEXAGON_SIZE = 8;
  public static final Point ORIGIN = new Point((SCREEN_HEIGHT/2 + (SCREEN_WIDTH-SCREEN_HEIGHT)),
      SCREEN_HEIGHT/2);
  public static final Integer NUMBER_OF_BLOCKS = 6;
  public static final int X_STEP = HEXAGON_SIZE * 3;
  public static final int Y_STEP_ONE = HEXAGON_SIZE * 2;
  public static final int Y_STEP_TWO = HEXAGON_SIZE * 4;


  private Boolean fogOfWar;
  private Integer numberOfPlayers;
  private Integer sizeOfMap;
  private Point origin;
  private Integer cellSize;


  public Config(Boolean fogOfWar, Integer numberOfPlayers, Integer sizeOfMap, Point origin,
                Integer cellSize) {
    this.fogOfWar = fogOfWar;
    this.numberOfPlayers = numberOfPlayers;
    this.sizeOfMap = sizeOfMap;
    this.origin = origin;
    this.cellSize = cellSize;
  }

  public Config () {
    this.fogOfWar = DEFAULT_FOG_VALUE;
    this.numberOfPlayers = DEFAULT_NUMBER_OF_PLAYERS;
    this.sizeOfMap = DEFAULT_SIZE_OF_MAP;
    this.origin = ORIGIN;
    this.cellSize = HEXAGON_SIZE;
  }

  public Boolean getFogOfWar() {
    return fogOfWar;
  }

  public void setFogOfWar(Boolean fogOfWar) {
    this.fogOfWar = fogOfWar;
  }

  public Integer getNumberOfPlayers() {
    return numberOfPlayers;
  }

  public void setNumberOfPlayers(Integer numberOfPlayers) {
    this.numberOfPlayers = numberOfPlayers;
  }

  public Integer getSizeOfMap() {
    return sizeOfMap;
  }

  public Integer getCellSize() {
    return cellSize;
  }

  public Point getOrigin() {
    return origin;
  }
}
