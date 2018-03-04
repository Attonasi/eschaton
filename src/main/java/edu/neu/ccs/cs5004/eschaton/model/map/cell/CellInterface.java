package edu.neu.ccs.cs5004.eschaton.model.map.cell;

import edu.neu.ccs.cs5004.eschaton.model.player.empire.deckitems.units.Unit;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.contents.Contents;
import edu.neu.ccs.cs5004.eschaton.model.player.Player;

import java.util.List;

/**
 * The Cells are the containers of game information. They are the way we organize and maintain
 * the locations of Player units, terrain, resources, and control values. These are all abstracted
 * out into the class Contents. A Cell is going to have 5 fields:
 *
 * - Contents contents
 * - List<Unit> unitList
 * - Integer special
 * - CellPosition cellPosition
 * - Point point
 */
public interface CellInterface {

  /**
   * @return Contents the resource return values for the cell.
   */
  public Contents getContents();

  /** A function to facilitate adding a Unit to the units in the cell.
   *
   * @param unit Unit being added to the list
   */
  void addUnit(Unit unit);

  /**
   * @param unit Unit either moves out or is pushed out of a cell it is removed from the Cell.
   */
  void removeUnit(Unit unit);

  /**
   * @return List of the units in the cell.
   */
  List<Unit> getUnits();

  /**
   * @param list a list of units attacking a cell.
   * @return Integer total attack value based on using the total attack value of units on the list and counting the
   * number of successes that group has in the attack.
   */
  Integer getAttackValue(List<Unit> list);

  /**
   * @param list a list of units attacking a cell.
   * @return Integer total defense value based on using the total defense value of units on the list and counting the
   * number of successes that group has in the defense.
   */
  Integer getDefenseValue(List<Unit> list);

  /** When a unit is declared attacking a cell it is added to a list for that cell. During the combat resolution phase
   * the list is iterated and the attack all happens at once. This list is cleared after the attack.
   * @param unit Unit being added to a list of units attacking the cell.
   */
  void buildAttackList(Unit unit);

  /**
   * Takes an existing village owned by a player and upgrades it to the next level of village.
   *
   * @param player Player has a bank to check available resources against and spend to upgrade the village.
   */
  void upgradeVillage(Player player);

  /** If all of the defending units in a village are driven out or destroyed the village is sacked by the attacking
   * player.
   * @param attacker
   * @param defender
   */
  void sackVillage(Player attacker, Player defender);
}
