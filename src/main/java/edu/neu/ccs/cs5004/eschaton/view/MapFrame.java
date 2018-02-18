package edu.neu.ccs.cs5004.eschaton.view;

import java.awt.*;
import edu.neu.ccs.cs5004.eschaton.view.objectmakers.Hexagon;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.MapPrinter;

import static edu.neu.ccs.cs5004.eschaton.config.Config.ORIGIN;

public class MapFrame extends Window {

  public MapFrame(String name, int width, int height) {
    super(name, width, height);
  }

  @Override
  protected void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);

    graphics.setColor(Color.BLUE);
    MapPrinter.printMap(graphics, ORIGIN.x, ORIGIN.y);

    graphics.setColor(Color.YELLOW);
    graphics.fillPolygon(Hexagon.newHexagon(ORIGIN.x, ORIGIN.y));
  }
}
