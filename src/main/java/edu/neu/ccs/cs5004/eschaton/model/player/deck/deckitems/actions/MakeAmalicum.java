package edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.actions;

import edu.neu.ccs.cs5004.eschaton.model.player.Player;

public class MakeAmalicum extends Action{

  private int[] cost = {1, 1, 1, 1, 1, 0};
  private String name;

  public MakeAmalicum() {
    this.name = "Make Amalicum";
  }

  public String getName() {
    return name;
  }

  public String getDescription(){
    return "Use one of each resource to make one unit of Amalicum";
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
