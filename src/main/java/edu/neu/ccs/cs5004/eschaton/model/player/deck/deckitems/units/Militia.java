package edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.units;

import edu.neu.ccs.cs5004.eschaton.model.map.cell.cellposition.CellPosition;

public class Militia extends Unit {

  public Militia(CellPosition location){
    super(location);
    this.name = "Militia";
    this.totalHitPoints = 10;
    this.currentHitPoints = 10;
    this.attackPower = 3;
    this.defensePower = 3;
    this.movement = 1;
    this.range = 0;
  }

}
