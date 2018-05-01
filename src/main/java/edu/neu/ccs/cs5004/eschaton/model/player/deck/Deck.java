package edu.neu.ccs.cs5004.eschaton.model.player.deck;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import edu.neu.ccs.cs5004.eschaton.model.map.Map;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.Cell;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.cellposition.CellPosition;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.celltypes.Plains;
import edu.neu.ccs.cs5004.eschaton.model.player.Player;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.DeckItemInterface;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.actions.MakeAmalicum;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.units.Militia;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.village.Village;

import static edu.neu.ccs.cs5004.eschaton.config.Config.getRandomNumber;

public class Deck implements DeckInterface {

  private List<DeckItemInterface> deck = new ArrayList<DeckItemInterface>();
  private List<DeckItemInterface> discard = new ArrayList<DeckItemInterface>();
  private List<DeckItemInterface> hand = new ArrayList<DeckItemInterface>();
  private Map map;
  private Player player;
  private CellPosition startPosition;
  private Cell startCell;
  private Cell startCell2;

  public Deck(CellPosition startPosition, Map map, Player player) {
    this.startPosition = startPosition;
    this.map = map;
    this.player = player;
    this.startCell = map.getCellAtPosition(startPosition);
    this.startCell2 = map.getCellAtPoint(new Point(500, 310));

    deck.add(new Militia(startPosition));
    deck.add(new Militia(startPosition));
    deck.add(new MakeAmalicum());
    deck.add(new Village(player, startPosition, new Plains(startPosition, new Point(10, 10),
        2)));
    deck.add(new Militia(startPosition));
    deck.add(new MakeAmalicum());


    draw();
    draw();
    draw();
    draw();
  }

  /**
   * @return Deck for the player.
   */
  public List<DeckItemInterface> getDeck() {
    return deck;
  }

  /**
   * @return Discard pile for the player.
   */
  public List<DeckItemInterface> getDiscard() {
    return discard;
  }

  /**
   * @return Hand for the player.
   */
  public List<DeckItemInterface> getHand() {
    return hand;
  }
  /**
   * Adds a new deckList item to a deckList. It actually goes in the discard list but it eventually makes
   * it's way to the deckList.
   *
   * @param newItem DeckItemInterface to be added to the deckList.
   */
  @Override
  public void addDeckItem(DeckItemInterface newItem) {
    discard.add(newItem);
  }

  /**
   * Removes an item from a deckList.
   *
   * @param removedItem DeckItem to be removed.
   */
  @Override
  public void removeDeckItem(DeckItemInterface removedItem) {
    for(DeckItemInterface item : deck){
      if(item == removedItem){
        deck.remove(item);
        break;
      }
    }
  }

  /**
   * When the deck becomes empty the discard pile has it's cards placed in the deck in random order
   * simulating shuffling.
   */
  @Override
  public void shuffle() {
    int number = getRandomNumber(discard.size(), 0, 1);

    deck.add(discard.get(number));
    discard.remove(number);

    if (discard.size() > 0){ shuffle(); }
  }

  /**
   * Takes a card from the deck and puts it in the players hand.
   */
  public void draw() {
    hand.add(deck.get(0));
    deck.remove(0);

    if (deck.size() < 1){
      shuffle();
    }
  }

  /**
   * Takes a card out o the hand and places it in the discard list.
   */
  public void playFromHand(DeckItemInterface card) {

    for(DeckItemInterface item : hand){
      if (item == card){
        hand.remove(item);
        discard.add(card);
      }
    }
  }

  /**
   * This will be the result of the action Hysteria, or Mass Hysteria. The affected players will
   * discard 2 cards at random from their hand to the discard pile.
   */
  @Override
  public void discardFromHand() {
    for(int i = 0; i<2; i++){
      int number = getRandomNumber(hand.size(), 0, 1);
      discard.add(hand.get(number));
      hand.remove(number);
    }
  }
}
