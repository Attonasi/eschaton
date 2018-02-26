package edu.neu.ccs.cs5004.eschaton.model.player;

public class Player implements PlayerInterface {

//  private Bank bank;
//  private Army army;
  private String bank = "Bank";
  private String army = "Army";


  public Player(String bank, String army) {
    this.bank = bank;
    this.army = army;
  }

  public String getBank() {
    return bank;
  }

  public String getArmy() {
    return army;
  }
}
