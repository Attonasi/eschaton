package edu.neu.ccs.cs5004.eschaton.config;

import java.awt.*;

/**
 * When the person creating the game sets the parameters of the game they are stored here
 */
public class Config {

  public static final String GAME_NAME = "Eschaton";
  public static final Integer DEFAULT_NUMBER_OF_PLAYERS = 2;
  public static final Integer DEFAULT_SIZE_OF_MAP = 8;
  public static final Boolean FOG_VALUE = false;
  public static final Integer SCREEN_HEIGHT = 1000;
  public static final Integer SCREEN_WIDTH = 1200;
  public static final Integer HEXAGON_SIZE = SCREEN_HEIGHT / 60;
  public static final Point ORIGIN = new Point((SCREEN_HEIGHT/2 + (SCREEN_WIDTH-SCREEN_HEIGHT)+100),
      SCREEN_HEIGHT/2);
  public static final Integer NUMBER_OF_BLOCKS = 6;
  private static final int X_STEP = HEXAGON_SIZE * 3;
  private static final int Y_STEP_ONE = HEXAGON_SIZE * 2;
  private static final int Y_STEP_TWO = HEXAGON_SIZE * 4;


  private Boolean fogOfWar;
  private Integer numberOfPlayers;
  private Integer sizeOfMap;
  private Integer hexagonSize;
  private Point origin;


  public Config() {
    this.fogOfWar = FOG_VALUE;
    this.numberOfPlayers = DEFAULT_NUMBER_OF_PLAYERS;
    this.sizeOfMap = DEFAULT_SIZE_OF_MAP;
    this.hexagonSize = HEXAGON_SIZE;
    this.origin = ORIGIN;
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

  public Integer getHexagonSize() {
    return hexagonSize;
  }

  public Point getOrigin() {
    return origin;
  }
}
