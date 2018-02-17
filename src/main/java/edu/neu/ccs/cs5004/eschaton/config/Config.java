package edu.neu.ccs.cs5004.eschaton.config;

/**
 * When the person creating the game sets the parameters of the game they are stored here
 */
public class Config {

  public static final String GAME_NAME = "Eschaton";
  public static final Integer DEFAULT_NUMBER_OF_PLAYERS = 2;
  public static final Boolean FOG_VALUE = false;
  public static final Integer SCREEN_HEIGHT = 1000;
  public static final Integer SCREEN_WIDTH = 1200;

  private Boolean fogOfWar;
  private Integer numberOfPlayers;

  public Config() {
    this.fogOfWar = FOG_VALUE;
    this.numberOfPlayers = DEFAULT_NUMBER_OF_PLAYERS;
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
}
