package edu.neu.ccs.cs5004.eschaton.config;

/**
 * When the person creating the game sets the parameters of the game they are stored here
 */
public class Config {

  private Boolean fogOfWar;
  private Integer numberOfPlayers;

  public Config() {
    this.fogOfWar = false;
    this.numberOfPlayers = 2;
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
