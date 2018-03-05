package edu.neu.ccs.cs5004.eschaton.model.map.cell;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;


import edu.neu.ccs.cs5004.eschaton.model.Units.Militia;
import edu.neu.ccs.cs5004.eschaton.model.Units.Unit;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.cellposition.CellPosition;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.contents.Contents;
import edu.neu.ccs.cs5004.eschaton.model.player.Player;

public abstract class Cell implements CellInterface{

  /**
   * There are 6 types of concrete Cells, BlockOne, BlockTwo, BlockThree, BlockFour, BlockFive, and
   * BlockSix.
   */
  protected CellPosition cellPosition;
  protected Point point;
  protected Contents contents;
  protected Integer special;
  protected ArrayList<Unit> unitList = new ArrayList<Unit>();


  public Cell(CellPosition cellPosition, Point point, Integer special) {
    this.cellPosition = cellPosition;
    this.point = point;
    this.special = special;
    this.contents = createCellContents();
    this.unitList = unitList;
    unitList.add(new Militia());
  }

  protected abstract Contents createCellContents();

  /**A function to facilitate adding a Unit to the units in the cell.
   * @param unit Unit being added to the list
   */
  @Override
  public void addUnit(Unit unit) {
    unitList.add(unit);
  }

  /**
   * @param unit Unit either moves out or is pushed out of a cell it is removed from the Cell.
   */
  @Override
  public void removeUnit(Unit unit) {

  }

  /**
   * @return List of the units in the cell.
   */
  @Override
  public List<Unit> getUnits() {
    return null;
  }

  /**
   * @param list a list of units attacking a cell.
   * @return Integer total attack value based on using the total attack value of Units on the list and counting the
   * number of successes that group has in the attack.
   */
  @Override
  public Integer getAttackValue(List<Unit> list) {
    return null;
  }

  /**
   * @param list a list of units attacking a cell.
   * @return Integer total defense value based on using the total defense value of Units on the list and counting the
   * number of successes that group has in the defense.
   */
  @Override
  public Integer getDefenseValue(List<Unit> list) {
    return null;
  }

  /**
   * When a unit is declared attacking a cell it is added to a list for that cell. During the combat resolution phase
   * the list is iterated and the attack all happens at once. This list is cleared after the attack.
   *
   * @param unit Unit being added to a list of units attacking the cell.
   */
  @Override
  public void buildAttackList(Unit unit) {

  }

  /**
   * Takes an existing village owned by a player and upgrades it to the next level of village.
   *
   * @param player Player has a bank to check available resources against and spend to upgrade the village.
   */
  @Override
  public void upgradeVillage(Player player) {

  }

  /**
   * If all of the defending units in a village are driven out or destroyed the village is sacked by the attacking
   * player.
   *
   * @param attacker
   * @param defender
   */
  @Override
  public void sackVillage(Player attacker, Player defender) {

  }

  public CellPosition getCellPosition() {
    return cellPosition;
  }

  public Point getPoint() {
    return point;
  }

  public Color getCellColor(){
    return Color.GREEN;
  }

  @Override
  public Contents getContents() {
    return contents;
  }

  public Integer getSpecial() {
    return special;
  }

  public ArrayList<Unit> getUnitList() {
    return unitList;
  }
}
