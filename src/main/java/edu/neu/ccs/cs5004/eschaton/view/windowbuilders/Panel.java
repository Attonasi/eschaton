package edu.neu.ccs.cs5004.eschaton.view.windowbuilders;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public interface Panel extends ActionListener, MouseListener, MouseMotionListener {

  /** I am building this interface amd am abstract to try to make this more OO.
   *
   * Stop Laughing.
   */


  /**This is a getter for all of the panels used to build the map window. Each one will have a
   * parent JPanel and this will get it.
   *
   * @return JPanel
   */
  public JPanel getPanel();

  /**Each panel will have it's own build panel method that adds buttons and components to that
   * JPanel object. This will be called by the constructor.
   *
   */
  public void  buildPanel();
}
