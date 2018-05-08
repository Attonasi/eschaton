package edu.neu.ccs.cs5004.eschaton.controller.rest;

import com.google.gson.Gson;
import edu.neu.ccs.cs5004.eschaton.controller.json.jsonpackages.HarvestJsonPackage;
import edu.neu.ccs.cs5004.eschaton.model.Model;
import edu.neu.ccs.cs5004.eschaton.model.player.Player;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.DeckItemInterface;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.village.Village;
import org.apache.http.client.HttpClient;

public class HarvestPOST extends AbstractCommand{


  public HarvestPOST(Model model, HttpClient client, Gson gson, String host, String port, String flag) {
    super(model, client, gson, host, port, flag);
  }

  public void execute(Player player, DeckItemInterface village) {

    Village arg = (Village) village;

    System.out.println(" player " + player.getPlayerNumber());
    System.out.println(" harvest " + arg.getHarvestBounty()[0]);
    HarvestJsonPackage sendHarvest = new HarvestJsonPackage(player.getPlayerNumber(), arg.getHarvestBounty());
    String harvestString = gson.toJson(sendHarvest);

    System.out.println(harvestString);

    String responseJSON = POST(harvestString);

    System.out.println(responseJSON);

    HarvestJsonPackage responseBank = gson.fromJson(responseJSON, HarvestJsonPackage.class);

    System.out.println(responseBank);


  }
}
