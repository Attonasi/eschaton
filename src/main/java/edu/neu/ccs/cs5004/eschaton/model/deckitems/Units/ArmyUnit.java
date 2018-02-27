package edu.neu.ccs.cs5004.eschaton.model.deckitems.Units;

public abstract class ArmyUnit implements UnitInterface {

  protected String unitName;
  protected Integer hitPoints;

  public ArmyUnit(String unitName, Integer hitPoints) {
    this.unitName = unitName;
    this.hitPoints = hitPoints;
  }
}
