package edu.neu.ccs.cs5004.eschaton.model.Units;

public abstract class Unit {

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
}
