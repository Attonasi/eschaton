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

public class Window extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
  public static JFrame FRAME;
  public static Window PANEL; // JPanel that is also a lisener
  public static JPanel MAP_PANEL;
  public static JPanel TILE_PANEL;
  public static JPanel ARMY_PANEL;
  public static String TITLE = "No Name";
  public static Dimension PREF_SIZE = new Dimension(500,400);

  public Window(String t, int w, int h){
    TITLE = t; PREF_SIZE = new Dimension(w,h);
  }

  public Dimension getPreferredSize() {return PREF_SIZE;}

  private static void createAndShowGUI(){
    FRAME = new JFrame(TITLE);
    FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    FRAME.addKeyListener(PANEL); // keyListener added to frame
    FRAME.getContentPane().add(PANEL);
    FRAME.pack();
    FRAME.setVisible(true);
    FRAME.setResizable(false);
    PANEL.setBackground(Color.BLACK);

    TILE_PANEL = new JPanel();
    FRAME.getContentPane().add(TILE_PANEL);
    TILE_PANEL.setBackground(Color.BLUE);
    TILE_PANEL.setBounds(5, 5, 300, 400);
    TILE_PANEL.setVisible(true);

    ARMY_PANEL = new JPanel();
    FRAME.getContentPane().add(ARMY_PANEL);
    ARMY_PANEL.setBackground(Color.GREEN);
    ARMY_PANEL.setBounds(5, 410, 300, 400);
    ARMY_PANEL.setVisible(true);

    MAP_PANEL = new JPanel();
    FRAME.getContentPane().add(MAP_PANEL);
    MAP_PANEL.setBackground(Color.BLACK);
    MAP_PANEL.setBounds(310, 5, 800, 800);
    MAP_PANEL.setVisible(true);


  }
  public static void launch(){
    // add in the listeners first
    PANEL.addMouseListener(PANEL); // mouseListeners added to panel
    PANEL.addMouseMotionListener(PANEL);

    javax.swing.SwingUtilities.invokeLater(
        new Runnable(){ public void run(){createAndShowGUI();} }
    );
  }

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
