package edu.neu.ccs.cs5004.eschaton.view.windowbuilders;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import edu.neu.ccs.cs5004.eschaton.model.Model;
import edu.neu.ccs.cs5004.eschaton.view.GameFrame;

public class UnitPanel extends JPanel implements Panel {

  protected JPanel unitPanel;
  protected JButton jButton;


//  BufferedImage buttonIcon = ImageIO.read(new File("/image/ship2.png"));

  public UnitPanel() throws IOException {
    this.unitPanel = new JPanel();
    buildPanel();
  }

  /**
   * This is a getter for all of the panels used to build the map window. Each one will have a
   * parent JPanel and this will get it.
   *
   * @return JPanel
   */

  public JPanel getPanel() {
    return unitPanel;
  }

  /**
   * Each panel will have it's own build panel method that adds buttons and components to that
   * JPanel object. This will be called by the constructor.
   */
  @Override
  public void buildPanel() {
    int number = 0;

    unitPanel.setLayout(null);
    unitPanel.setBackground(Color.GREEN);
    unitPanel.setBounds(5, 310, 250, 300);
    unitPanel.setVisible(true);
    Border blackline = BorderFactory.createLineBorder(Color.RED);
    unitPanel.setBorder(blackline);

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
