package edu.neu.ccs.cs5004.eschaton.controller.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.neu.ccs.cs5004.eschaton.model.player.Player;

public class GsonController {

  public Gson gson = new GsonBuilder().create();


  public GsonController(Gson gson) {
    this.gson = gson;
  }


}
