package edu.neu.ccs.cs5004.eschaton.model.player.bank;



public interface BankInterface {

  /**
   * @param food Integer how much food the item requires.
   * @param wood Integer how much wood the item requires.
   * @param iron Integer how much iron the item requires.
   * @param stone Integer how much stone the item requires.
   * @param gold Integer how much gold the item requires.
   * @param amalicum Integer how much magicium the item requires.
   * @return Boolean based on the cost of an item the player wants to purchase returns a true if they
   * can afford it and false otherwise.
   */
  Boolean isValidPurchase(Integer food, Integer wood, Integer iron,
                          Integer stone, Integer gold, Integer amalicum);
}
