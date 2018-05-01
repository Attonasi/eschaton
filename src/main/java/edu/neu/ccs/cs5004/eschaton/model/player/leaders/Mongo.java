package edu.neu.ccs.cs5004.eschaton.model.player.leaders;

public class Mongo implements LeaderInterface{

  /**
   * Monga holds a place in the list. He will bring you drinks. In the game not for real. He
   * doesn't get added to your deck.
   */
  public Mongo(){}

  public String getLeader(){
    return "Mongo";
  }
}
