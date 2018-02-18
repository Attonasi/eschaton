package edu.neu.ccs.cs5004.eschaton;

import edu.neu.ccs.cs5004.eschaton.config.Config;
import edu.neu.ccs.cs5004.eschaton.model.Model;
import edu.neu.ccs.cs5004.eschaton.view.GameFrame;

import static edu.neu.ccs.cs5004.eschaton.config.Config.SCREEN_HEIGHT;
import static edu.neu.ccs.cs5004.eschaton.config.Config.SCREEN_WIDTH;
import static edu.neu.ccs.cs5004.eschaton.view.Window.PANEL;
import static edu.neu.ccs.cs5004.eschaton.view.Window.launch;

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

  public static void main( String[] args )
    {

      Config config = new Config();

      Eschaton eschaton = new Eschaton(config, new Model(config),
                          new GameFrame(config.GAME_NAME, SCREEN_WIDTH, SCREEN_HEIGHT));

      PANEL = eschaton.gameFrame;
      launch();
    }
}
