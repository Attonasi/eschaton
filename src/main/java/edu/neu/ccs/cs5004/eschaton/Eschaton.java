package edu.neu.ccs.cs5004.eschaton;

import java.io.IOException;

import edu.neu.ccs.cs5004.eschaton.config.Config;
import edu.neu.ccs.cs5004.eschaton.model.Model;
import edu.neu.ccs.cs5004.eschaton.view.GameFrame;

import static edu.neu.ccs.cs5004.eschaton.config.Config.*;


/**
 * This is the class for the Game of Eschaton. Her the config is set and the module parts of the
 * game are created.
 *
 */
public class Eschaton {


  private Config config;
  private Model model;
  private GameFrame gameFrame;
  private String[] playerList = {"Player 1", "Player 2"};

  public Eschaton(Config config, Model model, GameFrame gameFrame) {
    this.config = config;
    this.model = model;
    this.gameFrame = gameFrame;
  }

  public static void main( String[] args ) throws IOException {

    Config config = new Config(6);

    Model model = new Model(config);

    GameFrame gameFrame = new GameFrame(model, config.GAME_NAME, SCREEN_WIDTH, SCREEN_HEIGHT);


    Eschaton eschaton = new Eschaton(config, model, gameFrame);

    gameFrame.launch(model);
  }
}
