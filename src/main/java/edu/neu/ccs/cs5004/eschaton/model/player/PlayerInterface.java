package edu.neu.ccs.cs5004.eschaton.model.player;

import edu.neu.ccs.cs5004.eschaton.model.deckitems.DeckItemInterface;

/**
 * Each player is going to have a Bank, an Integer empireScore, a DiscardDeck, and a DeckList.
 *
 * - The Bank represents the resources the player has to spend on new units, villages, and upgrades.
 * - The DeckList represents the current Units, Villages, and Actions a Player has at their disposal.
 * - The empireScore represents the achievement level of the player's empire.
 *
 * In the end the Player wins the game by achieving a pre-determined empireScore. Villages and certain Village upgrades
 * contribute to the empireScore.
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
}
