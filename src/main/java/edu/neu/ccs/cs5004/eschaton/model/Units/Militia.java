package edu.neu.ccs.cs5004.eschaton.model.Units;

public class Militia extends Unit {

  public Militia(String name, Integer hitPoints, Integer attackPower,
                 Integer defensePower, Integer range, Integer movement) {
    super(name, hitPoints, attackPower, defensePower, range, movement);
  }

  public Militia(){
    this.name = "Militia";
    this.hitPoints = 10;
    this.attackPower = 3;
    this.defensePower = 3;
    this.movement = 1;
    this.range = 1;
  }

  public String getName(){
    return name;
  }
}
