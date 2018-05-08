package edu.neu.ccs.cs5004.eschaton.model.player.bank;

import java.util.Arrays;
import java.util.Objects;

import edu.neu.ccs.cs5004.eschaton.model.player.Player;

public class Bank implements BankInterface {

  private Integer food = 10;
  private Integer wood = 0;
  private Integer stone = 0;
  private Integer iron = 0;
  private Integer gold = 5;
  private Integer amalicum = 0;
  private Integer[] bank = {food, wood, stone, iron, gold, amalicum};

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
    this.food = food;
    this.wood = wood;
    this.stone = stone;
    this.iron = iron;
    this.gold = gold;
    this.amalicum = amalicum;
  }

  public Integer[] getBankArray(){ return bank; }

  public Integer getFood() {
    return food;
  }

  public void setFood(Integer food) {
    this.food = food;
  }

  public Integer getWood() { return wood;  }

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

  public Integer getGold() { return gold; }

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
   * @param cost Integer[] how much amalicum the item requires for each type of resource.
   * @return Boolean based on the cost of an item the player wants to purchase returns a true if they
   * can afford it and false otherwise.
   */
  @Override
  public Boolean isValidPurchase(Player player, Integer[] cost) {
    for(Integer amount : cost){
      if (player.getBankArray()[amount] > cost[amount]){ return false; }
    }
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Bank bank = (Bank) o;
    return food == bank.food &&
        wood == bank.wood &&
        stone == bank.stone &&
        iron == bank.iron &&
        gold == bank.gold &&
        amalicum == bank.amalicum;
  }

  @Override
  public int hashCode() { return Objects.hash(food, wood, stone, iron, gold, amalicum); }

  @Override
  public String toString() {
    return "Bank{" +
        "food=" + food +
        ", wood=" + wood +
        ", stone=" + stone +
        ", iron=" + iron +
        ", gold=" + gold +
        ", amalicum=" + amalicum +
        '}';
  }
}
