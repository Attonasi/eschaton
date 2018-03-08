package edu.neu.ccs.cs5004.eschaton.model.player.race;

public class Geodians implements Race{
  /**
   * A race that provides no bonuses and holds a place.
   */

  public Geodians(){}

  /**
   * @return String name of race.
   */
  @Override
  public String getNameString() {
    return "Geodians";
  }
}