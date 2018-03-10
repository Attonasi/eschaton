package edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.actions;

import edu.neu.ccs.cs5004.eschaton.model.player.Player;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.DeckItemInterface;

public interface ActionInterface extends DeckItemInterface {


  /**
   * When a Player plays an action each action card has unique results that occur. Every action can be played.
   * This just detemines what happens.
   *
   * @param player Player that plays the action.
   */
  void playAction(Player player);

  /**
   * Every Action has a cost. This will be a helper method called byt the playAction method to adjust the player's
   * bank totals.
   *
   * @param player Player that played the action and needs to spend money to do so.
   */
  void payCost(Player player, int[] cost);

  String getDescription();
}
