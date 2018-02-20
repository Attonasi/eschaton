package edu.neu.ccs.cs5004.eschaton.view;

/**
 * This is a window builder class with the basic mouse and keyboard listeners and a constructor to
 * build an empty window.
 *
 * This will be expanded to display all sorts of stuff.
 */


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.MapPanel;

public class Window extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
  public static JFrame FRAME;
  public static Window PANEL; // JPanel that is also a lisener
  public static JPanel MAP_PANEL;
  public static JPanel TILE_PANEL;
  public static JPanel UNIT_PANEL;
  public static String TITLE = "Eschaton";
  public static Dimension PREF_SIZE = new Dimension(1005,705);

  public Window(String t, int w, int h){
    TITLE = t;
    PREF_SIZE = new Dimension(w,h);
  }

  public Dimension getPreferredSize() {return PREF_SIZE;}

  @Override
  public void mouseClicked(MouseEvent me){}
  @Override
  public void mousePressed(MouseEvent me) {}
  @Override
  public void mouseReleased(MouseEvent me) {}

  @Override
  public void mouseEntered(MouseEvent me) {}
  @Override
  public void mouseExited(MouseEvent me) {}
  @Override
  public void mouseDragged(MouseEvent me) {}
  @Override
  public void mouseMoved(MouseEvent me) {}

  @Override
  public void keyTyped(KeyEvent ke) {}
  @Override
  public void keyPressed(KeyEvent ke) {}
  @Override
  public void keyReleased(KeyEvent ke) {}
}
