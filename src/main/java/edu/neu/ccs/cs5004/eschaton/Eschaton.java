package edu.neu.ccs.cs5004.eschaton;

import edu.neu.ccs.cs5004.eschaton.config.Config;
import edu.neu.ccs.cs5004.eschaton.model.Model;
import edu.neu.ccs.cs5004.eschaton.view.GameFrame;

import static edu.neu.ccs.cs5004.eschaton.config.Config.DEFAULT_NUMBER_OF_PLAYERS;
import static edu.neu.ccs.cs5004.eschaton.config.Config.DEFAULT_SIZE_OF_MAP;
import static edu.neu.ccs.cs5004.eschaton.config.Config.FOG_VALUE;
import static edu.neu.ccs.cs5004.eschaton.config.Config.HEXAGON_SIZE;
import static edu.neu.ccs.cs5004.eschaton.config.Config.ORIGIN;
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

      Config config = new Config(FOG_VALUE, DEFAULT_NUMBER_OF_PLAYERS, DEFAULT_SIZE_OF_MAP,
          ORIGIN, SCREEN_HEIGHT/HEXAGON_SIZE);

      Model model = new Model(config);

      Eschaton eschaton = new Eschaton(config, model,
                          new GameFrame(model, config.GAME_NAME, SCREEN_WIDTH, SCREEN_HEIGHT));

      PANEL = eschaton.gameFrame;
      launch();
    }
}
