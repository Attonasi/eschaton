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

public class DeckPanel extends JPanel implements Panel {

  protected JPanel deckPanel;
  protected JTextField itemNameField;


//  BufferedImage buttonIcon = ImageIO.read(new File("/image/ship2.png"));

  public DeckPanel() throws IOException {
    this.deckPanel = new JPanel();
    deckPanel.setLayout(null);
    deckPanel.setBackground(Color.GREEN);
    deckPanel.setBounds(5, 340, 345, 315);
    deckPanel.setVisible(true);
    Border blackline = BorderFactory.createLineBorder(Color.RED);
    deckPanel.setBorder(blackline);

    itemNameField = new JTextField();
    itemNameField.setBounds(20,  20, 300, 30);
    itemNameField.setVisible(true);
    itemNameField.setFont(new Font("Arial", Font.PLAIN, 20));
    itemNameField.setHorizontalAlignment(JTextField.CENTER);
    itemNameField.setText("Select an item from your hand");
    deckPanel.add(itemNameField);
  }

  /**
   * This is a getter for all of the panels used to build the map window. Each one will have a
   * parent JPanel and this will get it.
   *
   * @return JPanel
   */

  public JPanel getPanel() {
    return deckPanel;
  }

  /**
   * Each panel will have it's own build panel method that adds buttons and components to that
   * JPanel object. This will be called by the constructor.
   */

  public JTextField getItemNameField() { return itemNameField; }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {  }
  @Override
  public void mouseClicked(MouseEvent mouseEvent) {  }
  @Override
  public void mousePressed(MouseEvent mouseEvent) {  }
  @Override
  public void mouseReleased(MouseEvent mouseEvent) {  }
  @Override
  public void mouseEntered(MouseEvent mouseEvent) {  }
  @Override
  public void mouseExited(MouseEvent mouseEvent) {  }
  @Override
  public void mouseDragged(MouseEvent mouseEvent) {  }
  @Override
  public void mouseMoved(MouseEvent mouseEvent) {  }
}
