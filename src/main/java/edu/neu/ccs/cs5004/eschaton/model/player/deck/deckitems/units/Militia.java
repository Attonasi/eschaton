package edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.units;

import edu.neu.ccs.cs5004.eschaton.model.map.cell.cellposition.CellPosition;

public class Militia extends Unit {

  public Militia(String name, Integer hitPoints, Integer attackPower,
                 Integer defensePower, Integer range, Integer movement,
                 CellPosition location) {
    super(name, hitPoints, attackPower, defensePower, range, movement, location);
  }

  public Militia(CellPosition location){
    super(location);
    this.name = "Militia";
    this.hitPoints = 10;
    this.attackPower = 3;
    this.defensePower = 3;
    this.movement = 1;
    this.range = 0;
  }

}
