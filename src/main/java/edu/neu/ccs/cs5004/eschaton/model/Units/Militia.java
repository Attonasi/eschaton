package edu.neu.ccs.cs5004.eschaton.model.Units;

public class Militia extends Unit {


  public Militia(String name, Integer hitPoints) {
    super(name, hitPoints);
  }

  public Militia(){
    this.name = "Militia";
    this.hitPoints = 20;
  }
}
