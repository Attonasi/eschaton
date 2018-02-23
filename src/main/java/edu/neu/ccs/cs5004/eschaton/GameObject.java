package edu.neu.ccs.cs5004.eschaton;

import java.io.IOException;

import edu.neu.ccs.cs5004.eschaton.config.Config;
import edu.neu.ccs.cs5004.eschaton.model.Model;
import edu.neu.ccs.cs5004.eschaton.view.GameFrame;
import edu.neu.ccs.cs5004.eschaton.view.Window;

public class GameObject {

  private Config config;
  private Model model;
  private Window gameFrame;
  private String[] playerList = {"Player 1", "Player 2"};

  public GameObject(Config config) {
    this.config = config;
    this.model = new Model(config);
    this.gameFrame = new GameFrame(model, "Ecshaton", config.SCREEN_WIDTH,
        config.SCREEN_HEIGHT);
  }


  public void startGame() throws IOException {
    GameFrame.launch(model);
  }
}
