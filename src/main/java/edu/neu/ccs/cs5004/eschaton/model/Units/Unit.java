package edu.neu.ccs.cs5004.eschaton.model.Units;

public abstract class Unit implements UnitInterface{

  protected String name;
  protected Integer hitPoints;


  public Unit(String name, Integer hitPoints) {
    this.name = name;
    this.hitPoints = hitPoints;
  }

  protected Unit() {
  }

  public Integer getHitPoints() {
    return hitPoints;
  }
  public String getName() {
    return name;
  }
}
