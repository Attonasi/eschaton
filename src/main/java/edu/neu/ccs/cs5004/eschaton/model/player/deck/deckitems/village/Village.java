package edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.village;

import edu.neu.ccs.cs5004.eschaton.model.map.cell.Cell;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.cellposition.CellPosition;
import edu.neu.ccs.cs5004.eschaton.model.player.Player;

public class Village extends AbstractVillage {

  private Integer defense;
  private Integer population;

  public Village(Player player, CellPosition position, Cell cell) {
    super(player, position, cell);
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
