package edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.village.buildings;

import java.lang.reflect.Array;

public interface BuildingInterface {

  /**
   * @return Array of Integers that have the Wood, Stone, Iron, Gold, and Amalicum cost to build
   * each building.
   */
  Array getCost();

}
