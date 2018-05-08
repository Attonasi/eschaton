package edu.neu.ccs.cs5004.eschaton.model.player;

import java.util.List;

import edu.neu.ccs.cs5004.eschaton.model.player.bank.Bank;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.Deck;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.DeckItemInterface;
import edu.neu.ccs.cs5004.eschaton.model.player.leaders.LeaderInterface;
import edu.neu.ccs.cs5004.eschaton.model.player.race.Race;

/**
 * Each player is going to have the following fields:
 * - Score
 * The player has items in their deck that give them victory points. The total number of
 * points in the score. The player wins when they acquire the agreed upon number of points.
 *
 * - Bank
 *  The bank is the total resources the Player has to spend on actions, units and
 *  villages in a turn.
 *
 * - Deck
 * The deck is a measure of the accumulated deck of te player. It contains villages,
 * units, actions, and buildings.
 *
 * - Races
 * This is the race of people that inhabit the deck. There will be opportunities to
 * add more races to your deck as the game progresses. Races all have particular traits
 * and bonuses.
 *
 * - Leaders
 * Commanders will serve at your behest if you pay them. Like races you will be able to
 * add more commanders to your army as the game progresses.
 *
 * - PlayerBonuses
 * There are going to be so many weird bonuses and combinations a player can make that there
 * needs to be a place to put them all and add them all up. This is going to be a convoluted
 * bunch of return methods so the rest of the game code can stay somewhat clean and simple.
 */
public interface PlayerInterface {

  /**
   * @return The next card from the Player's DeckList used for purposes of advancing the current turn.
   */
  DeckItemInterface getNextCard();

  /**
   * When the player no longer has cards left in their Deck the discardDeck is shuffled and
   */
  void shuffleDeck();

   /** @return Integer score of the player that represents the total number of victory points
   * the player has.
   */
  Integer getScore();

  /**
   * @return Bank of the player.
   */
  Bank getBank();

  /**
   * @return Deck of the player represented by the list of items including units, villages,
   * actions, and buildings.
   */
  Deck getDeck();


  /**
   * @return List of Races that inhabit the player's deck.
   */
  Race getRace();

  /**
   * @return List of commanders in a Players Deck
   */
  LeaderInterface getLeader();

  /**
   * @return PlayerBonus gives the rest of the program access to a players bonus variables in order
   * to do what it needs to do.
   */
  PlayerBonus getPlayerBonus();
}
