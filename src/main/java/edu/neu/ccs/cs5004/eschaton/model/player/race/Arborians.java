package edu.neu.ccs.cs5004.eschaton.model.player.race;

public class Arborians implements Race{
  /**
   * A race that provides no bonuses and holds a place.
   */

  public Arborians(){}

  /**
   * @return String name of race.
   */
  @Override
  public String getNameString() {
    return "Arborians";
  }
}