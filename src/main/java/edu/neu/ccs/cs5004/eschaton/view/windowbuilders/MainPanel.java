package edu.neu.ccs.cs5004.eschaton.view.windowbuilders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class MainPanel implements Panel {

  protected JPanel mainPanel;

  public MainPanel() {
    this.mainPanel = new JPanel();
    buildPanel();
  }

  /**
   * This is a getter for all of the panels used to build the map window. Each one will have a
   * parent JPanel and this will get it.
   *
   * @return JPanel
   */
  @Override
  public JPanel getPanel() {
    return mainPanel;
  }

  /**
   * Each panel will have it's own build panel method that adds buttons and components to that
   * JPanel object. This will be called by the constructor.
   */
  @Override
  public void buildPanel() {
    mainPanel.setBounds(0, 0, 1305, 705);
    mainPanel.setBackground(Color.BLACK);
    mainPanel.setVisible(false);
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {

  }

  @Override
  public void mouseClicked(MouseEvent mouseEvent) {

  }

  @Override
  public void mousePressed(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseReleased(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseEntered(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseExited(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseDragged(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseMoved(MouseEvent mouseEvent) {

  }
}
