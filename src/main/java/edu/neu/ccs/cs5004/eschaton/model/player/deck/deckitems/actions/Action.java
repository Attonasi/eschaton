package edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.actions;

import edu.neu.ccs.cs5004.eschaton.model.player.Player;

public abstract class Action implements ActionInterface{

  private int[] cost = {0, 0, 0, 0, 0, 0};

  public Action(int[] cost) { this.cost = cost; }

  public Action(){ }

  /**
   * Every Action has a cost. This will be a helper method called byt the playAction method to adjust the player's
   * bank totals.
   *
   * @param player Player that played the action and needs to spend money to do so.
   */
  public void payCost(Player player, int[] cost) {
    for(int amount : cost){
      player.getBankArray()[amount] -= cost[amount];
    }
  }
}
