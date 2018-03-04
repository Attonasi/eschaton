package edu.neu.ccs.cs5004.eschaton.model.player.bank;

public class Bank implements BankInterface {

  private Integer food;
  private Integer wood;
  private Integer stone;
  private Integer iron;
  private Integer gold;
  private Integer amalicum;

  public Bank(Integer food, Integer wood, Integer stone,
              Integer iron, Integer gold, Integer amalicum) {

    this.food = food;
    this.wood = wood;
    this.stone = stone;
    this.iron = iron;
    this.gold = gold;
    this.amalicum = amalicum;
  }

  public Bank(){
    this.food = 10;
    this.wood = 0;
    this.stone = 0;
    this.iron = 0;
    this.gold = 5;
    this.amalicum = 0;
  }

  public Integer getFood() {
    return food;
  }

  public void setFood(Integer food) {
    this.food = food;
  }

  public Integer getWood() {
    return wood;
  }

  public void setWood(Integer wood) {
    this.wood = wood;
  }

  public Integer getStone() {
    return stone;
  }

  public void setStone(Integer stone) {
    this.stone = stone;
  }

  public Integer getIron() {
    return iron;
  }

  public void setIron(Integer iron) {
    this.iron = iron;
  }

  public Integer getGold() {
    return gold;
  }

  public void setGold(Integer gold) {
    this.gold = gold;
  }

  public Integer getAmalicum() {
    return amalicum;
  }

  public void setAmalicum(Integer amalicum) {
    this.amalicum = amalicum;
  }

  /**
   * @param food       Integer how much food the item requires.
   * @param wood       Integer how much wood the item requires.
   * @param iron       Integer how much iron the item requires.
   * @param stone      Integer how much stone the item requires.
   * @param gold       Integer how much gold the item requires.
   * @param amalicum   Integer how much amalicum the item requires.
   * @return Boolean based on the cost of an item the player wants to purchase returns a true if they
   * can afford it and false otherwise.
   */
  @Override
  public Boolean isValidPurchase(Integer food, Integer wood, Integer iron, Integer stone, Integer gold, Integer amalicum) {
    return null;
  }
}
