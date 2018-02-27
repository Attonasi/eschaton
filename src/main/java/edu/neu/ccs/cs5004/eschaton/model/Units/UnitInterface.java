package edu.neu.ccs.cs5004.eschaton.model.Units;

import edu.neu.ccs.cs5004.eschaton.model.map.Map;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.CellPosition;

public interface UnitInterface {

  /**
   * A Unit has 3 main types:
   *
   * -Infantry
   *    Low movement high attack/defense power
   * -Cavalry
   *    High movement but weaker attack values at similar levels
   * -Ranged
   *    Slow and weak but can shoot into adjacent cells without counter attack
   *
   *  While there are 3 different general types of units there will only be 2 abstract versions,
   *  ranged and melee.  Every unit will move just some will move further. The ability to attack
   *  without closing and risking counter attack will result in a separate attack method but the
   *  rest will remain the same as far as defense and other unit functions.
   *
   *  All units will have the following fields all generally self documenting:
   *
   *  - String Name
   *  - Hit Points
   *  - Attack Power
   *  - Defense Power
   *  - Movement
   *  - Range
   *
   *  The will be a separate attack method for melee attacks and for ranged attacks. In general that
   *  will probably be the only methods that are handled outside the abstract unit class.
   *
   *  The following methods will be common between all units
   */

   /**
   *  moveUnit() when called will change the position of the unit to the newPosition given.
   *
   *  @param newPosition
   */

  void moveUnit(CellPosition newPosition);

  /**
   * This method will check the units movement speed, map position, and surrounding area for enemy
   * units and return whether the unit can move to the given position.
   * @param unit Unit trying to move.
   * @param position CellPosition the unit is trying to move to.
   * @param map A map the function can query for enemy units and terrain issues.
   * @return Boolean true if the Unit can move to the square and false otherwise.
   */
  Boolean checkValidMove(Unit unit, CellPosition position, Map map);

  /**
   * When a unit attacks a unit from another player this method will handle the combat. The player
   * attacking will be asked if they wish to move into the occupied square upon victory.
   *
   * @param moveIntoSquare An option the attacking player has to move the unit attacking into the
   *                       target cell on a successful attack.
   */
  void attackCell(Boolean moveIntoSquare);

  /**
   * When a defending player unit is attacked the player can choose to voluntarily retreat or hold
   * ground. If the player chooses to hold ground and the attacker tries to push them out then this
   * method determines the result.
   *
   * @param isVillage Boolean whether the defending unit is defending a village. It gets bonuses for
   *                  holding ground in a village controlled by the player.
   * @param attackDamage Integer how much damage the attacker dealt.
   * @param defenseDamage Integer how much damage the defender prevented.
   * @return Boolean true if the attacker overwhelmed the defender and false otherwise.
   */
  Boolean isUnitDisplaced(Boolean isVillage, Integer attackDamage, Integer defenseDamage,
                          Boolean wantToRetreat);

  /**
   * When there is combat the units involved will take damage. This method determines how much.
   * @param attackerPower
   * @param defenderDefense
   * @return
   */
  Integer damageUnit(Integer attackerPower, Integer defenderDefense);
}
