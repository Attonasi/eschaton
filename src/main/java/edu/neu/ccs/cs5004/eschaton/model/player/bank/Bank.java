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
}
