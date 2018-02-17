package edu.neu.ccs.cs5004.eschaton;

import javax.swing.text.View;

import edu.neu.ccs.cs5004.eschaton.config.Config;
import edu.neu.ccs.cs5004.eschaton.model.Model;
import edu.neu.ccs.cs5004.eschaton.model.map.Map;
import edu.neu.ccs.cs5004.eschaton.view.MapFrame;

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
  private View view;

  public Eschaton(Config config, Model model, View view) {
    this.config = config;
    this.model = model;
    this.view = view;
  }

  public static void main( String[] args )
    {
      PANEL = new MapFrame(Config.GAME_NAME, SCREEN_WIDTH, SCREEN_HEIGHT);


      launch();
    }
}
