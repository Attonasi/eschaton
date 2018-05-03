package edu.neu.ccs.cs5004.eschaton.model;

import java.util.ArrayList;
import java.util.List;

import edu.neu.ccs.cs5004.eschaton.config.Config;
import edu.neu.ccs.cs5004.eschaton.model.map.Map;
import edu.neu.ccs.cs5004.eschaton.model.player.Player;

public class Model implements ModelInterface {

  private Config config;
  private Map map;
  private List<Player> players = new ArrayList<Player>();

  public Model(Config config) {
    this.config = config;
    this.map = new Map(config);
//    this.players = new ArrayList<>();
    for(int i = 0; i < config.getNumberOfPlayers(); i++){
      players.add(new Player(config.getPlayerStartPositions()[i], map, i));
    }
    players.get(1).getDeck().draw();
  }

  public Map getMap() {
    return map;
  }

  public Config getConfig() {
    return config;
  }

  public List<Player> getPlayers() {
    return players;
  }
}
