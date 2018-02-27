package edu.neu.ccs.cs5004.eschaton.model.player;

import edu.neu.ccs.cs5004.eschaton.model.deckitems.DeckItemInterface;
import edu.neu.ccs.cs5004.eschaton.model.player.bank.Bank;

import java.util.ArrayList;

public class Player implements PlayerInterface {

  private ArrayList<DeckItemInterface> stackList;
  private Bank bank;

  public Player(Bank bank, ArrayList<DeckItemInterface> stackList) {
    this.bank = bank;
    this.stackList = stackList;
  }

  public Bank getBank() {
    return bank;
  }

  public ArrayList<DeckItemInterface> getStackList() {
    return stackList;
  }
}
