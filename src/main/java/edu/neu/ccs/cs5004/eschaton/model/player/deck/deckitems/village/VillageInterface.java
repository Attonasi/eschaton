package edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.village;

import edu.neu.ccs.cs5004.eschaton.model.map.cell.Cell;
import edu.neu.ccs.cs5004.eschaton.model.player.Player;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.DeckItemInterface;

/**
 * A village has the following fields:
 * - Player
 * - CellPosition
 * - harvestBounty
 * - Defense
 *
 *  Villages provide the resources for an Empire. They are also the places where improvements are
 *  built.
 */
public interface VillageInterface extends DeckItemInterface {

  /**
   * @return Player
   */
  Player getPlayer();

  /**
   * @return CellPosition of the village.
   */
  Cell getCell();

  /**
   * @return int[] containing the resources a player gains when they harvest this cell.
   */
  Integer[] getHarvestBounty();

  /**
   * @return Integer defense value of the village when attacked.
   */
  Integer getDefense();

  /**
   * @return Card that will be added to the players deck.
   */
  void build();

  /**
   * Adds the harvest from the village to the player's bank total.
   */
  void harvest();
}
