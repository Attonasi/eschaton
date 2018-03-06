package edu.neu.ccs.cs5004.eschaton.model;

import java.util.ArrayList;

import edu.neu.ccs.cs5004.eschaton.config.Config;
import edu.neu.ccs.cs5004.eschaton.model.map.Map;
import edu.neu.ccs.cs5004.eschaton.model.player.Player;

public class Model implements ModelInterface {

  private Config config;
  private Map map;
  private ArrayList<Player> players = new ArrayList<Player>();

  public Model(Config config) {
    this.config = config;
    this.map = new Map();
    this.players = new ArrayList<Player>();
    for(int i = 0; i < config.getNumberOfPlayers(); i++){
      players.add(new Player());
    }
  }

  public Map getMap() {
    return map;
  }

  public Config getConfig() {
    return config;
  }

  public ArrayList<Player> getPlayers() {
    return players;
  }
}
