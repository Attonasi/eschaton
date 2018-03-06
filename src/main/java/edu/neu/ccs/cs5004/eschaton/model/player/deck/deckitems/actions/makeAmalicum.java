package edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.actions;

import edu.neu.ccs.cs5004.eschaton.model.player.Player;

public class makeAmalicum extends Action{

  private int[] cost;

  public makeAmalicum() {
    // This action costs 1 of each resource
    for (int unit: cost){
      cost[unit]++;
    }
  }

  /**
   * When a Player plays an action each action card has unique results that occur. Every action can be played.
   * This just detemines what happens.
   *
   * @param player Player that plays the action.
   */
  @Override
  public void playAction(Player player) {
    if(player.getBank().isValidPurchase(player, cost)) {
      player.getBank().setAmalicum(player.getBank().getAmalicum() + 1);
      payCost(player, cost);
    }else{
      System.out.println("You don't have enough resources");
    }
  }
}
