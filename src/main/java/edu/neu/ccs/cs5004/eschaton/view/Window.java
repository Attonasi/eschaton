package edu.neu.ccs.cs5004.eschaton.view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.MapPanel;

/**
 * This is a window builder class with the basic mouse and keyboard listeners because it allows all of the Panels below
 * it to inherit that stand a constructor to build an empty window.
 *
 * This will be expanded to display all sorts of stuff.
 */

public class Window extends JPanel  {
  public static String TITLE = "Eschaton";
  public static Dimension WINDOW_SIZE = new Dimension(1005,605);

  public Window(String t, int w, int h){
    TITLE = t;
    WINDOW_SIZE = new Dimension(w,h);
  }

  public Dimension getPreferredSize() {return WINDOW_SIZE;}

}
