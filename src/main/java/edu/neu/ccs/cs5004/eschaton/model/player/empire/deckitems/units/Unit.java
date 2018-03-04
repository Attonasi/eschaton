package edu.neu.ccs.cs5004.eschaton.model.player.empire.deckitems.units;

import edu.neu.ccs.cs5004.eschaton.model.map.Map;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.Cell;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.CellPosition;

public abstract class Unit implements UnitInterface{

  protected String name;
  protected Integer hitPoints;
  protected Integer attackPower;
  protected Integer defensePower;
  protected Integer range;
  protected Integer movement;

  public Unit(String name, Integer hitPoints, Integer attackPower,
              Integer defensePower, Integer range, Integer movement) {

    this.name = name;
    this.hitPoints = hitPoints;
    this.attackPower = attackPower;
    this.defensePower = defensePower;
    this.range = range;
    this.movement = movement;
  }

  public Unit(){}

  public String getName() {
    return name;
  }

  /**
   * moveUnit() when called will change the position of the unit to the newPosition given.
   */
  @Override
  public void moveUnit(CellPosition newPosition) {

  }

  /**
   * This method will check the units movement speed, map position, and surrounding area for enemy
   * units and return whether the unit can move to the given position.
   *
   * @param unit     Unit trying to move.
   * @param position CellPosition the unit is trying to move to.
   * @param map      A map the function can query for enemy units and terrain issues.
   * @return Boolean true if the Unit can move to the square and false otherwise.
   */
  @Override
  public Boolean checkValidMove(Unit unit, CellPosition position, Map map) {
    return null;
  }

  /**
   * When a unit attacks a unit from another player this method will handle the combat. The player
   * attacking will be asked if they wish to move into the occupied square upon victory.
   *
   * @param moveIntoSquare An option the attacking player has to move the unit attacking into the
   *                       target cell on a successful attack.
   */
  @Override
  public void attackCell(Boolean moveIntoSquare) {

  }

  /**
   * When a defending player unit is attacked the player can choose to voluntarily retreat or hold
   * ground. If the player chooses to hold ground and the attacker tries to push them out then this
   * method determines the result.
   *
   * @param isVillage     Boolean whether the defending unit is defending a village. It gets bonuses for
   *                      holding ground in a village controlled by the player.
   * @param attackDamage  Integer how much damage the attacker dealt.
   * @param defenseDamage Integer how much damage the defender prevented.
   * @return Boolean true if the attacker overwhelmed the defender and false otherwise.
   */
  @Override
  public Boolean isUnitDisplaced(Boolean isVillage, Integer attackDamage, Integer defenseDamage, Boolean wantToRetreat) {
    return null;
  }

  /**
   * When there is combat the units involved will take damage. This method determines how much.
   *
   * @return Integer the number of hit points the unit loses in combat this round.
   */
  @Override
  public Integer damageUnit(Integer attackerPower, Integer defenderDefense) {
    return null;
  }

  /**
   * A unit that stays in place for a turn can heal. This is greatly increased if they hold in place in Cells with
   * villages or lots of food.
   *
   * @param cell Cell the unit occupies.
   */
  @Override
  public void restUnit(Cell cell) {

  }

  /**
   * A unit can fortify itself in a Cell. It gains bonuses to defense doing this and a fortified unit will automatically
   * gain the bonuses as if resting.
   */
  @Override
  public void fortify() {

  }
}
