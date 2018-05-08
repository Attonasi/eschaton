package edu.neu.ccs.cs5004.eschaton.controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.neu.ccs.cs5004.eschaton.config.Config;
import edu.neu.ccs.cs5004.eschaton.controller.rest.HarvestPOST;
import edu.neu.ccs.cs5004.eschaton.model.Model;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

public class Controller {

  private Config config;
  private Model model;

  private static final String HOST = "http://localhost";
  private static final String PORT = ":8080";

  private static final String HARVEST = "/harvest";

  private HttpClient client = new DefaultHttpClient();

  private Gson gson = new GsonBuilder().create();

  public Controller(Config config, Model model){

    this.config = config;
    this.model = model;
    System.out.println(model);
  }

  private HarvestPOST harvest = new HarvestPOST(model, client, gson, HOST, PORT, HARVEST);

  public HarvestPOST executeHarvest() { return harvest; }
}
