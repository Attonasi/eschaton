package edu.neu.ccs.cs5004.eschaton.model.player;

import edu.neu.ccs.cs5004.eschaton.model.StackItems.StackItemInterface;
import edu.neu.ccs.cs5004.eschaton.model.player.bank.Bank;

import java.util.ArrayList;

public class Player implements PlayerInterface {

  private ArrayList<StackItemInterface> stackList;
  private Bank bank;
//  private ArrayList<Village> villageList;


  public Player(Bank bank, ArrayList<StackItemInterface> stackList) {
    this.bank = bank;
    this.stackList = stackList;
  }

  public Bank getBank() {
    return bank;
  }

  public ArrayList<StackItemInterface> getStackList() {
    return stackList;
  }
}
