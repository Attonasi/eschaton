package edu.neu.ccs.cs5004.eschaton.view.windowbuilders.panelbuttons;

import java.awt.*;

import javax.swing.*;


import edu.neu.ccs.cs5004.eschaton.model.map.cell.Cell;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.cellposition.CellPosition;

/**
 * The MapPanelCell Is a class that contains several abstract objects including the actual Cell,
 * a Button that includes a listener, and eventually the icon used to represent the cell.  It
 * will also contain the 3 digit grid location and the x and y coordinates for a point.
 */

public interface MapPanelCellIInterface {

  /**
   * @return The entire position if that is more convenient.
   */
  Point getPoint();

  /**
   * @return int how far from origin the circle of hexagons this cell is in is.
   */
  CellPosition getCellPosition();


  /**
   * @return JButton the object that has the listeners attached to it.
   */
  JButton getButton();

  /**
   * @return The cell which holds the type, units, upgrades and special resources contained in the
   * MapPanelCell
   */
  Cell getCell();
}
