package edu.neu.ccs.cs5004.eschaton.model.player.deck;

import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.DeckItemInterface;

public interface DeckInterface {

  /**
   * Adds a new deck item to a deck
   * @param newItem DeckItemInterface to be added to the deck.
   */
  void addDeckItem(DeckItemInterface newItem);

  /**
   * Removes an item from a deck.
   * @param removedItem DeckItem to be removed.
   */
  void removeDeckItem(DeckItemInterface removedItem);

  /**
   * When the deck becomes empty the discard pile has it's cards placed in the deck in random order
   * simulating shuffling.
   */
  void shuffle();

  /**
   * Takes a card from the deck and puts it in the players hand.
   */
  void draw();

  /**
   * Takes a card out o the hand and places it in the discard list.
   */
  void playFromHand(DeckItemInterface card);

  /**
   * This will be the result of the action Hysteria, or Mass Hysteria. The affected players will
   * discard 2 cards at random from their hand to the discard pile.
   */
  void discardFromHand();

}
