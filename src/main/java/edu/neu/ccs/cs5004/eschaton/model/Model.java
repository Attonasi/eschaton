package edu.neu.ccs.cs5004.eschaton.model;

import java.util.ArrayList;

import edu.neu.ccs.cs5004.eschaton.config.Config;
import edu.neu.ccs.cs5004.eschaton.model.map.Map;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.Cell;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.celltypes.Plains;
import edu.neu.ccs.cs5004.eschaton.model.players.Player;

public class Model implements ModelInterface {

  private Config config;
  private Map map;
  private ArrayList<Player> players = new ArrayList<Player>();

  public Model(Config config) {
    this.config = config;
    this.map = new Map();
    this.players = new ArrayList<Player>();
    players.add(new Player("bank", "army"));
    players.add(new Player("bank2", "army2"));
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
