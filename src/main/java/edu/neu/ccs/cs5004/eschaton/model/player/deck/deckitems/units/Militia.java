package edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.units;


import edu.neu.ccs.cs5004.eschaton.model.map.cell.Cell;

public class Militia extends Unit {

  public Militia(Cell cell){
    super(cell);
    this.name = "Militia";
    this.totalHitPoints = 10;
    this.currentHitPoints = 10;
    this.attackPower = 3;
    this.defensePower = 3;
    this.movement = 1;
    this.range = 0;
    cell.addUnit(this);
  }



}
