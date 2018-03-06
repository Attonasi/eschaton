package edu.neu.ccs.cs5004.eschaton.model.player;

import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.DeckItemInterface;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.units.Militia;
import edu.neu.ccs.cs5004.eschaton.model.player.leaders.LeaderInterface;
import edu.neu.ccs.cs5004.eschaton.model.player.leaders.Mongo;
import edu.neu.ccs.cs5004.eschaton.model.player.bank.Bank;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.Deck;
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
    this.bank = new Bank();
    this.races = new ArrayList<Race>();
    this.leaders = new ArrayList<LeaderInterface>();
    this.playerBonus = new PlayerBonus(races, leaders);
  }

  private void buildNewPlayer(){
    deck.add(new Militia());

    races.add(new Simulacra());
    leaders.add(new Mongo());
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
   * @return int[] that holds the bank values of hte Players bank.
   */
  public int[] getBankArray() {
    return bank.getBank();
  }

  /**
   * @return Deck of the player represented by the list of items including units, villages,
   * actions, and buildings.
   */
  @Override
  public Deck getEmpire() {
    return null;
  }

  /**
   * @return List of Races that inhabit the player's deck.
   */
  @Override
  public List getRaces() {
    return null;
  }

  /**
   * @return List of commanders in a Players Deck
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

  /**
   * @return The next card from the Player's DeckList used for purposes of advancing the current turn.
   */
  @Override
  public DeckItemInterface getNextCard() {
    return null;
  }

  /**
   * When the player no longer has cards left in their Deck the discardDeck is shuffled and
   */
  @Override
  public void shuffleDeck() {

  }
}
