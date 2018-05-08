package edu.neu.ccs.cs5004.eschaton.model.player;


import java.util.List;

import edu.neu.ccs.cs5004.eschaton.model.player.leaders.LeaderInterface;
import edu.neu.ccs.cs5004.eschaton.model.player.race.Race;

/**
 * This is a holding pen for the bonuses that leaders and races give to a player. The constructor
 * sets the Booleans and Integers for each field based on which races and commanders the player has
 * in their Deck.
 *
 * In order to provide bonuses that are not easily definable like the Angelic's telepathy there are
 * going to be some messy places. This class is an attempt to put most of the mess in one place.
 */
public class PlayerBonus {

  private Boolean foodHarvestBonus;
  private Boolean buildingsCostHalfBonus;
  private Boolean stoneHarvestBonus;
  private Boolean ironHarvestBonus;
  private Boolean movementBonus;
  private Boolean settlerLessWheatToBuildBonus;
  private Boolean unitsLessFoodBonus;
  private Integer bonusAttackDice;
  private Integer bonusDefenseDice;
  private Integer bonusArcherDice;
  private Boolean bonusAmlicumProduction;
  private Boolean unitsCitiesNoFoodBonus;
  private Boolean cantAttackUsBonus;
  private Boolean noSackLootBonus;

  public PlayerBonus(Race race, LeaderInterface leader) {
    this.foodHarvestBonus = foodHarvestBonus;
    this.buildingsCostHalfBonus = buildingsCostHalfBonus;
    this.stoneHarvestBonus = stoneHarvestBonus;
    this.ironHarvestBonus = ironHarvestBonus;
    this.movementBonus = movementBonus;
    this.settlerLessWheatToBuildBonus = settlerLessWheatToBuildBonus;
    this.unitsLessFoodBonus = unitsLessFoodBonus;
    this.bonusAttackDice = bonusAttackDice;
    this.bonusDefenseDice = bonusDefenseDice;
    this.bonusArcherDice = bonusArcherDice;
    this.bonusAmlicumProduction = bonusAmlicumProduction;
    this.unitsCitiesNoFoodBonus = unitsCitiesNoFoodBonus;
    this.cantAttackUsBonus = cantAttackUsBonus;
    this.noSackLootBonus = noSackLootBonus;
  }


}
