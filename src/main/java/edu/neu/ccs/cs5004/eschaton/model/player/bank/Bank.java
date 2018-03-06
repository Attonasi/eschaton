package edu.neu.ccs.cs5004.eschaton.model.player.bank;

import edu.neu.ccs.cs5004.eschaton.model.player.Player;

public class Bank implements BankInterface {

  private int food = 10;
  private int wood = 0;
  private int stone = 0;
  private int iron = 0;
  private int gold = 5;
  private int amalicum = 0;
  private int[] bank = {0,0,0,0,0,0};


  public Bank(Integer food, Integer wood, Integer stone,
              Integer iron, Integer gold, Integer amalicum) {

    this.bank[0] = food;
    this.bank[1] = wood;
    this.bank[2] = stone;
    this.bank[3] = iron;
    this.bank[4] = gold;
    this.bank[5] = amalicum;
  }

  public Bank(){
    this.bank[0] = food;
    this.bank[1] = wood;
    this.bank[2] = stone;
    this.bank[3] = iron;
    this.bank[4] = gold;
    this.bank[5] = amalicum;
  }

  public int getFood() {
    return bank[0];
  }

  public void setFood(int food) {
    this.bank[0] += food;
  }

  public int getWood() { return bank[1];  }

  public void setWood(int wood) {
    this.bank[1] += wood;
  }

  public int getStone() {
    return bank[2];
  }

  public void setStone(int stone) {
    this.bank[2] += stone;
  }

  public int getIron() {
    return bank[3];
  }

  public void setIron(int iron) {
    this.bank[3] += iron;
  }

  public int getGold() { return bank[4]; }

  public void setGold(int gold) {
    this.bank[4] += gold;
  }

  public int getAmalicum() {
    return bank[5];
  }

  public void setAmalicum(int amalicum) {
    this.bank[5] += amalicum;
  }

  public int[] getBank(){ return this.bank; }

  /**
   * @param cost int[] how much amalicum the item requires for each type of resource.
   * @return Boolean based on the cost of an item the player wants to purchase returns a true if they
   * can afford it and false otherwise.
   */
  @Override
  public Boolean isValidPurchase(Player player, int[] cost) {
    for(int amount : cost){
      if (player.getBankArray()[amount] > cost[amount]){ return false; }
    }
    return true;
  }
  
}
