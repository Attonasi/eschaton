package edu.neu.ccs.cs5004.eschaton.model;

import java.util.ArrayList;

import edu.neu.ccs.cs5004.eschaton.model.map.Map;
import edu.neu.ccs.cs5004.eschaton.model.players.Player;

public class Model implements ModelInterface {

  private Map map;
  private ArrayList<Player> players;

  public Model(Map map, ArrayList<Player> players) {
    this.map = map;
    this.players = players;
  }

  public Map getMap() {
    return map;
  }

  public ArrayList<Player> getPlayers() {
    return players;
  }
}
