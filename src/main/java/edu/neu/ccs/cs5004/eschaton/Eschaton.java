package edu.neu.ccs.cs5004.eschaton;

import edu.neu.ccs.cs5004.eschaton.config.Config;
import edu.neu.ccs.cs5004.eschaton.model.Model;
import edu.neu.ccs.cs5004.eschaton.view.GameFrame;
import edu.neu.ccs.cs5004.eschaton.view.Window;

import static edu.neu.ccs.cs5004.eschaton.config.Config.*;
import static edu.neu.ccs.cs5004.eschaton.view.GameFrame.launch;
import static edu.neu.ccs.cs5004.eschaton.view.Window.PANEL;


/**
 * This is the class for the Game of Eschaton. Her the config is set and the module parts of the
 * game are created.
 *
 */
public class Eschaton {


  private Config config;
  private Model model;
  private Window gameFrame;
  private String[] playerList = {"Player 1", "Player 2"};

  public Eschaton(Config config, Model model, Window gameFrame) {
    this.config = config;
    this.model = model;
    this.gameFrame = gameFrame;
  }

  public static void main( String[] args )
    {

      Config config = new Config();

      Model model = new Model(config);

      Eschaton eschaton = new Eschaton(config, model,
                          new GameFrame(model, config.GAME_NAME, SCREEN_WIDTH, SCREEN_HEIGHT));

      PANEL = eschaton.gameFrame;
      launch();
    }
}
