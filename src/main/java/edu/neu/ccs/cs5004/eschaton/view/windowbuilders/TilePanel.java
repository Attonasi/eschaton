package edu.neu.ccs.cs5004.eschaton.view.windowbuilders;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;

import edu.neu.ccs.cs5004.eschaton.model.Model;
import edu.neu.ccs.cs5004.eschaton.view.GameFrame;

public class TilePanel extends JPanel implements Panel{

  private JPanel tilePanel;

  public TilePanel() {
    tilePanel = new JPanel();
    buildPanel();
  }

  /**
   * This is a getter for all of the panels used to build the map window. Each one will have a
   * parent JPanel and this will get it.
   *
   * @return JPanel
   */

  public JPanel getPanel() {
    return tilePanel;
  }

  public void buildPanel(){
    tilePanel.setBackground(Color.BLUE);
    tilePanel.setBounds(5, 5, 250, 300);
    tilePanel.setVisible(true);
    tilePanel.setLayout(null);
    Border blackline = BorderFactory.createLineBorder(Color.RED);
    tilePanel.setBorder(blackline);
  }

  protected void paintComponent(Graphics graphics){

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
