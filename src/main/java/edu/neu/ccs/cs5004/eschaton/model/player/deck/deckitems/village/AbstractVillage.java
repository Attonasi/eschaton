package edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.village;

import edu.neu.ccs.cs5004.eschaton.model.map.cell.Cell;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.cellposition.CellPosition;
import edu.neu.ccs.cs5004.eschaton.model.player.Player;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.DeckItemInterface;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.actions.MakeAmalicum;

public abstract class AbstractVillage implements VillageInterface{

  protected Player player;
  protected Integer[] harvestBounty;
  protected Cell cell;

  public AbstractVillage(Player player, Cell cell) {
    this.player = player;
    this.cell = cell;
    Integer[] newHarvest = {cell.getContents().getFood(),
                            cell.getContents().getWood(),
                            cell.getContents().getIron(),
                            cell.getContents().getStone(),
                            cell.getContents().getGold()};
    this.harvestBounty = newHarvest;
  }

  /**
   * @return Player
   */
  @Override
  public Player getPlayer() {
    return player;
  }

  /**
   * @return CellPosition of the village.
   */
  @Override
  public Cell getCell() {
    return cell;
  }

  /**
   * @return int[] containing the resources a player gains when they harvest this cell.
   */
  @Override
  public Integer[] getHarvestBounty() {
    return harvestBounty;
  }

  /**
   * @return Integer defense value of the village when attacked.
   */
  @Override
  public Integer getDefense() {
    return null;
  }

  /**
   * @return Card that will be added to the players deck.
   */
  @Override
  public void build() {
    DeckItemInterface newCard = new MakeAmalicum();
    player.getDeck().addDeckItem(newCard);
  }

  /**
   * @return String name of the deck item.
   */
  @Override
  public String getName() {
    return "Village";
  }

  /**
   * Adds the harvest from the village to the player's bank total.
   */
  public void harvest(){
    for(int resource: harvestBounty){
      player.getBank().getBankArray()[resource] += harvestBounty[resource];
    }
  }
}
