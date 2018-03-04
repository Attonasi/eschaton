package edu.neu.ccs.cs5004.eschaton.model.player;

import edu.neu.ccs.cs5004.eschaton.model.player.empire.deckitems.DeckItemInterface;
import edu.neu.ccs.cs5004.eschaton.model.player.empire.deckitems.units.Militia;
import edu.neu.ccs.cs5004.eschaton.model.player.leaders.LeaderInterface;
import edu.neu.ccs.cs5004.eschaton.model.player.leaders.Mongo;
import edu.neu.ccs.cs5004.eschaton.model.player.bank.Bank;
import edu.neu.ccs.cs5004.eschaton.model.player.empire.Empire;
import edu.neu.ccs.cs5004.eschaton.model.player.race.Race;
import edu.neu.ccs.cs5004.eschaton.model.player.race.Simulacra;

import java.util.ArrayList;
import java.util.List;

public class Player implements PlayerInterface {

  private Integer score;
  private ArrayList<DeckItemInterface> deck = new ArrayList<DeckItemInterface>();
  private Bank bank;
  private ArrayList<Race> races = new ArrayList<Race>();
  private ArrayList<LeaderInterface> leaders = new ArrayList<LeaderInterface>();
  private PlayerBonus playerBonus;

  public Player() {
    this.score = 0;
    this.deck = new ArrayList<DeckItemInterface>();
    deck.add(new Militia());
    this.bank = new Bank();
    this.races = new ArrayList<Race>();
    races.add(new Simulacra());
    this.leaders = new ArrayList<LeaderInterface>();
    leaders.add(new Mongo());
    this.playerBonus = new PlayerBonus(races, leaders);
  }


  /**
   * @return Integer score of the player that represents the total number of victory points
   * the player has.
   */
  @Override
  public Integer getScore() {
    return null;
  }

  public Bank getBank() {
    return bank;
  }

  /**
   * @return Empire of the player represented by the list of items including units, villages,
   * actions, and buildings.
   */
  @Override
  public Empire getEmpire() {
    return null;
  }

  /**
   * @return List of Races that inhabit the player's empire.
   */
  @Override
  public List getRaces() {
    return null;
  }

  /**
   * @return List of commanders in a Players Empire
   */
  @Override
  public List getCommanders() {
    return null;
  }

  /**
   * @return PlayerBonus gives the rest of the program access to a players bonus variables in order
   * to do what it needs to do.
   */
  @Override
  public PlayerBonus getPlayerBonus() {
    return null;
  }

  public ArrayList<DeckItemInterface> getStackList() {
    return deck;
  }
}
