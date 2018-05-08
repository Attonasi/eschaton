package edu.neu.ccs.cs5004.eschaton.controller.rest;

import edu.neu.ccs.cs5004.eschaton.model.player.Player;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.DeckItemInterface;

public interface CommandInterface {

//  String GET();
//
//  String POST(String json);

  void execute(Player player, DeckItemInterface village);
}
