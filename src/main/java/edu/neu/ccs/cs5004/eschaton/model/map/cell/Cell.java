package edu.neu.ccs.cs5004.eschaton.model.map.cell;


import java.awt.*;
import java.util.ArrayList;


import edu.neu.ccs.cs5004.eschaton.model.Units.Militia;
import edu.neu.ccs.cs5004.eschaton.model.Units.Unit;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.contents.Contents;

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
