package edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems;

/**
 * This cass/interface tree is merely a collection of get : return requests for the cost of every
 * deckitem in the game to facilitate the purchase of cards for a players deck.
 *
 * These items all cost a combination of the six resources in Eschaton.
 */
public interface DeckItemCostInterface {
  /**
   * UNITS
   *
   * Each of these functions returns the unique cost for a specific unit type.
   */
  /**
   * @return Cost of a new unit of Militia.
   */
  int[] getCostMilitia();

  /**
   * @return Cost of a new unit of Archers.
   */
  int[] getCostArchers();
  /**
   * @return Cost of a new unit of Settlers.
   */
  int[] getCostSettlers();
  /**
   * @return Cost of a new unit of Horsemen.
   */
  int[] getCostHorsemen();
  /**
   * @return Cost of a new unit of Spearmen.
   */
  int[] getCostSpearmen();
  /**
   * @return Cost of a new unit of Swordsmen.
   */
  int[] getCostSwordsmen();
  /**
   * @return Cost of a new unit of Longbowmen.
   */
  int[] getCostLongbowman();
  /**
   * @return Cost of a new unit of Cavalry.
   */
  int[] getCostCavalry();
  /**
   * @return Cost of a new unit of HeavyCrossbows.
   */
  int[] getCostHeavyCrossbows();
  /**
   * @return Cost of a new unit of Myrmidons.
   */
  int[] getCostMyrmidons();
  /**
   * @return Cost of a new unit of Phalanx.
   */
  int[] getCostPhalanx();
  /**
   * @return Cost of a new unit of Knights.
   */
  int[] getCostKnights();

  /**
   * VILLAGES
   *
   * You pay the cost of founding a village when you build settlers. When you upgrade to a Town or
   * a City these functions return the costs.
   */
  /**
   * @return Cost of a new unit of upgrading a village to a Town.
   */
  int[] getCostTownUpgrade();

  /**
   * @return Cost of a new unit of upgrading a Town to a City.
   */
  int[] getCostCityUpgrade();

  /**
   * ACTIONS
   *
   *
   */

  /**
   * LEADERS
   *
   * Leaders want gold. Doesn't everyone?
   */
}
