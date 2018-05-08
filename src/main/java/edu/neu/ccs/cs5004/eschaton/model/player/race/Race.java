package edu.neu.ccs.cs5004.eschaton.model.player.race;

/**
 * The game of Eschaton will be diverse. There will be over a dozen races in Eschaton that can be
 * added to an deck. Each race will ask for different things and provide an deck with unique
 * qualities. Skevix will multiply rapidly. Skeletons will convert fallen enemy units and towns to
 * your side. Dwarves will give your units bonus defense dice and mining advantages.
 *
 * The races are going to essentially be empty classes that exist for purposes of setting up the
 * PlayerBonus class
 */
public interface Race {

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
 *
 * Angelics
 * Cannot be attacked unless they attack first.
 * Telepathy(5 settlements harvest at once)
 *
 * Skeevix
 * Settlers no food cost
 * Harvest 3 villages at a time
 *
 * Undead
 * Units rise every turn
 * Fallen enemies come back as Militia or AbstractVillage
 *
 * Zedorats (zealots)
 * +1 attack dice
 * Attack Actions cost half
 *
 * Dwarves
 * units +1 defense
 * +1 Iron from Hills
 * +1 Stone from Mountains
 *
 * Elves
 * archery +1 attack
 * double amalicum production
 *
 * Geodians
 * units and cities don't require food. Require +1 stone to build
 * +1 defense dice for units/cities
 *
 * Arborians
 * Can make a village in a forest for free.
 * Can use wood for any resource
 */

  /**
   * @return String name of race.
   */
  String getNameString();
}
