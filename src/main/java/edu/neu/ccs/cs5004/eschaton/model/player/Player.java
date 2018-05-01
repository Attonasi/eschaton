package edu.neu.ccs.cs5004.eschaton.model.player;

import java.util.ArrayList;
import java.util.List;

import edu.neu.ccs.cs5004.eschaton.model.map.Map;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.cellposition.CellPosition;
import edu.neu.ccs.cs5004.eschaton.model.player.bank.Bank;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.Deck;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.DeckItemInterface;
import edu.neu.ccs.cs5004.eschaton.model.player.leaders.LeaderInterface;
import edu.neu.ccs.cs5004.eschaton.model.player.leaders.Mongo;
import edu.neu.ccs.cs5004.eschaton.model.player.race.Race;
import edu.neu.ccs.cs5004.eschaton.model.player.race.Simulacra;

public class Player implements PlayerInterface {

  private Integer score;
  private Deck deck;
  private Bank bank;
  private Race race;
  private LeaderInterface leader;
  private PlayerBonus playerBonus;
  private Integer playerNumber;
//  public CellPosition startPosition;


  public Player(CellPosition startPosition, Map map, int i) {
    this.score = 0;
    this.playerNumber = i+1;
    this.deck = new Deck(startPosition, map, this);
    this.bank = new Bank();
    this.race = new Simulacra();
    this.leader = new Mongo();
    this.playerBonus = new PlayerBonus(race, leader);
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
   * @return int[] that holds the bank values of the Players bank.
   */
  public int[] getBankArray() {
    return bank.getBank();
  }

  /**
   * @return Deck of the player represented by the list of items including units, villages,
   * actions, and buildings.
   */
  @Override
  public Deck getDeck() {
    return deck;
  }

  /**
   * @return List of Races that inhabit the player's deck.
   */
  @Override
  public Race getRace() {
    return race;
  }

  /**
   * @return List of commanders in a Players Deck
   */
  @Override
  public LeaderInterface getLeader() {
    return leader;
  }

  public Integer getPlayerNumber() { return playerNumber; }

  /**
   * @return PlayerBonus gives the rest of the program access to a players bonus variables in order
   * to do what it needs to do.
   */
  @Override
  public PlayerBonus getPlayerBonus() {
    return null;
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
