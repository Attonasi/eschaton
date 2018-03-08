package edu.neu.ccs.cs5004.eschaton.model.player.race;

public class Avians implements Race{
  /**
   * A race that provides no bonuses and holds a place.
   */

  public Avians(){}

  /**
   * @return String name of race.
   */
  @Override
  public String getNameString() {
    return "Avians";
  }
}