package edu.neu.ccs.cs5004.eschaton.config;

import java.awt.*;
import java.util.Arrays;
import java.util.Objects;

import edu.neu.ccs.cs5004.eschaton.model.map.cell.cellposition.CellPosition;

/**
 * When the person creating the game sets the parameters of the game they are stored here. There are
 * of course default values. Everything here is self documenting.
 */
public class Config {

  public static final String GAME_NAME = "Eschaton";
  public static final Integer DEFAULT_NUMBER_OF_PLAYERS = 6;
  public static final Integer DEFAULT_SIZE_OF_MAP = 9;
  public static final Boolean DEFAULT_FOG_VALUE = false;
  public static final Integer SCREEN_HEIGHT = 610;
  public static final Integer SCREEN_WIDTH = 1060;
  public static final Integer HEXAGON_SIZE = 8;
  public static final Point ORIGIN = new Point(SCREEN_WIDTH/2,
      SCREEN_HEIGHT/2);
  public static final Integer NUMBER_OF_BLOCKS = 6;
  public static final int X_STEP = HEXAGON_SIZE * 4;
  public static final int Y_STEP_ONE = HEXAGON_SIZE * 2;
  public static final int Y_STEP_TWO = HEXAGON_SIZE * 4;
  public static final CellPosition[] sixPlayerStartPositions = {
      new CellPosition(1, DEFAULT_SIZE_OF_MAP, 0 ),
      new CellPosition(2, DEFAULT_SIZE_OF_MAP, 0 ),
      new CellPosition(3, DEFAULT_SIZE_OF_MAP, 0 ),
      new CellPosition(4, DEFAULT_SIZE_OF_MAP, 0 ),
      new CellPosition(5, DEFAULT_SIZE_OF_MAP, 0 ),
      new CellPosition(6, DEFAULT_SIZE_OF_MAP, 0 ),
  };

  private Boolean fogOfWar;
  private Integer numberOfPlayers;
  private Integer sizeOfMap;
  private Point origin;
  private Integer cellSize;
  private CellPosition[] playerStartPositions;


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
    this.playerStartPositions = sixPlayerStartPositions;
  }

  public Config (Integer numberOfPlayers) {
    this.fogOfWar = DEFAULT_FOG_VALUE;
    this.numberOfPlayers = numberOfPlayers;
    this.sizeOfMap = numberOfPlayers + 3;
    this.origin = ORIGIN;
    this.cellSize = HEXAGON_SIZE;
    this.playerStartPositions = getStartPositions(sizeOfMap);
  }

  public static Integer getRandomNumber(Integer max, Integer min, Integer base){
    return base + (int)(Math.random()*((max-min)+base));
  }

  private CellPosition[] getStartPositions(int sizeOfMap){

    if(sizeOfMap == 4) {
      CellPosition[] start = {new CellPosition(1, sizeOfMap, 0),
                              new CellPosition(4, sizeOfMap, 0)};
      return start;
    } else if(sizeOfMap == 5) {
      CellPosition[] start = {new CellPosition(1, sizeOfMap, 0),
                              new CellPosition(3, sizeOfMap, 0),
                              new CellPosition(5, sizeOfMap, 0)};
      return start;
    } else if(sizeOfMap == 6) {
      CellPosition[] start = {new CellPosition(2, sizeOfMap, 0),
                              new CellPosition(3, sizeOfMap, 0),
                              new CellPosition(4, sizeOfMap, 0),
                              new CellPosition(5, sizeOfMap, 0)};

      return start;
    } else if(sizeOfMap == 7) {
      CellPosition[] start = {new CellPosition(1, sizeOfMap, 0),
                              new CellPosition(2, sizeOfMap, 0),
                              new CellPosition(3, sizeOfMap, 0),
                              new CellPosition(5, sizeOfMap, 0),
                              new CellPosition(6, sizeOfMap, 0)};
      return start;
    } else {
      CellPosition[] start = {new CellPosition(1, sizeOfMap, 0),
                              new CellPosition(2, sizeOfMap, 0),
                              new CellPosition(3, sizeOfMap, 0),
                              new CellPosition(4, sizeOfMap, 0),
                              new CellPosition(5, sizeOfMap, 0),
                              new CellPosition(6, sizeOfMap, 0)};
      return start;
    }
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

  public CellPosition[] getPlayerStartPositions() {
    return playerStartPositions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Config config = (Config) o;
    return Objects.equals(fogOfWar, config.fogOfWar) &&
        Objects.equals(numberOfPlayers, config.numberOfPlayers) &&
        Objects.equals(sizeOfMap, config.sizeOfMap) &&
        Objects.equals(origin, config.origin) &&
        Objects.equals(cellSize, config.cellSize) &&
        Arrays.equals(playerStartPositions, config.playerStartPositions);
  }

  @Override
  public int hashCode() {

    int result = Objects.hash(fogOfWar, numberOfPlayers, sizeOfMap, origin, cellSize);
    result = 31 * result + Arrays.hashCode(playerStartPositions);
    return result;
  }

  @Override
  public String toString() {
    return "Config{" +
        "fogOfWar=" + fogOfWar +
        ", numberOfPlayers=" + numberOfPlayers +
        ", sizeOfMap=" + sizeOfMap +
        ", origin=" + origin +
        ", cellSize=" + cellSize +
        ", playerStartPositions=" + Arrays.toString(playerStartPositions) +
        '}';
  }
}
