package edu.neu.ccs.cs5004.eschaton.view;

import java.awt.*;
import edu.neu.ccs.cs5004.eschaton.view.objectmakers.Hexagon;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.MapPrinter;

import static edu.neu.ccs.cs5004.eschaton.config.Config.ORIGIN;

public class GameFrame extends Window {

  public GameFrame(String name, int width, int height) {
    super(name, width, height);
  }

  @Override
  protected void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);

    graphics.setColor(Color.black);
    graphics.fillRect(0, 0, getWidth(), getHeight());
    graphics.setColor(Color.gray);
    graphics.fillRect(10, 10, getWidth() / 3 - 10,
        getHeight()/2 - 10);
    graphics.fillRect(10, getHeight()/2 + 10,
        getWidth() / 3 - 10, getHeight()/2 -20);
    graphics.fillRect(getWidth() / 3 + 10, 10,
        getWidth() - getWidth() /3 - 20, getHeight() - 20);

    MapPrinter.printMap(graphics, ORIGIN);

    graphics.setColor(Color.YELLOW);
    graphics.fillPolygon(Hexagon.newHexagon(new Point(ORIGIN.x, ORIGIN.y)));
  }
}
