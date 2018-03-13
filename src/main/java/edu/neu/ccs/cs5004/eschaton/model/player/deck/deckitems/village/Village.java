package edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.village;

import edu.neu.ccs.cs5004.eschaton.model.map.cell.Cell;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.cellposition.CellPosition;
import edu.neu.ccs.cs5004.eschaton.model.player.Player;

public class Village extends AbstractVillage {

  private Integer defense;
  private Integer population;
//  private int[] harvestValues = {0,0,0,0,0};

  public Village(Player player, CellPosition position, Cell cell) {
    super(player, position, cell);
//    this.harvestValues[0] = cell.getContents().getFood();
//    this.harvestValues[1] = cell.getContents().getWood();
//    this.harvestValues[2] = cell.getContents().getIron();
//    this.harvestValues[3] = cell.getContents().getStone();
//    this.harvestValues[4] = cell.getContents().getGold();
    this.defense = 1;
    this.population = 1;
  }

  @Override
  public CellPosition getPosition() {
    return super.getPosition();
  }

  @Override
  public Integer getDefense() {
    return defense;
  }

  public Integer getPopulation() {
    return population;
  }

//  public int[] getHarvestValues() {
//    return harvestValues;
//  }
}
