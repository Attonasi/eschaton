package edu.neu.ccs.cs5004.eschaton.model.player;

/**
 * PlayerBonuses
 *
 * There are going to be so many weird bonuses and combinations a player can make that there
 * needs to be a place to put them all and add them all up. This is going to be a convoluted
 * bunch of return methods so the rest of the game code can stay somewhat clean and simple.
 */
public interface PlayerBonusInterface {

  /**
   * List of Races:
   *
   * Humans
   * +1 food per tile
   * buildings and village upgrades cost half
   *
   * Avians
   * Non-mounted units +1 movement
   *
   * Angelics
   * Cannot be attacked unless they attack first.
   * Telepathy(5 settlements harvest at once)
   *
   * Skeevix
   * Settlers no food cost
   *
   *
   * Zombies
   * enemies get no loot from sacked cities
   * units rise every turn
   *
   * Skeletons
   * fallen enemies join your cause
   * razed villages become villages for you
   *
   * Tiflings
   * +1 attack dice
   *
   * Zedorats (zealots)
   * +1 attack dice
   *
   * Dwarves
   * units +1 defense
   * +1 Iron from Hills
   * +1 Stone from Mountains
   *
   * Elves
   * archery bonus
   * magic cheaper
   *
   * Geodians
   * units and cities don't require food. Require +1 stone to build
   * +1 defense dice for units/cities
   *
   * Arborians
   * Can make a village in a forest for free.
   * +1 food from forest tiles
   */


}
