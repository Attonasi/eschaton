package edu.neu.ccs.cs5004.eschaton.model.map.cell.contents;

public interface ContentsInteface {

  /**
   * This is the abstract of the contents of a Cell. Lost of things can be in here. This is
   * abstracted to the following Integer values representing the number of each resource the
   * Cell produces:
   *
   * - Wood
   * - Food
   * - Iron
   * - Stone
   * - Gold
   */

  /**
   * @return Integer the base amount of Wood produced by this cell when collected by the player
   * every rotation.
   */
  Integer getWood();


  /**
   * @return Integer the base amount of Food produced by this cell when collected by the player
   * every rotation.
   */
  Integer getFood();

  /**
   * @return Integer the base amount of Iron produced by this cell when collected by the player
   * every rotation.
   */
  Integer getIron();

  /**
   * @return Integer the base amount of Stone produced by this cell when collected by the player
   * every rotation.
   */
  Integer getStone();

  /**
   * @return Integer the base amount of Gold produced by this cell when collected by the player
   * every rotation.
   */
  Integer getGold();
}
