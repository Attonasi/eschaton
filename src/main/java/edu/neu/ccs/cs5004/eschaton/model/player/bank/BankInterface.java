package edu.neu.ccs.cs5004.eschaton.model.player.bank;

import edu.neu.ccs.cs5004.eschaton.model.player.Player;

public interface BankInterface {

  /**
   * @param player Player making a purchase.
   * @param cost int[] how much the item costs.
   * @return Boolean based on the cost of an item the player wants to purchase returns a true if they
   * can afford it and false otherwise.
   */
  Boolean isValidPurchase(Player player, int[] cost);
}
