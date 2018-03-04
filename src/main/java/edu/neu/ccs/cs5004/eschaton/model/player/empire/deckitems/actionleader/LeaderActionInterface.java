package edu.neu.ccs.cs5004.eschaton.model.player.empire.deckitems.actionleader;

/**
 * Leaders give your empire a bonus and provide your deck with an action. This interface and the
 * classes that implement it reflect the action that goes in your deck.
 */
public interface LeaderActionInterface {


  /**
   * When a leader card is played this function contains the happiness and joy that ensues.
   */
  void playLeaderAction();
}
