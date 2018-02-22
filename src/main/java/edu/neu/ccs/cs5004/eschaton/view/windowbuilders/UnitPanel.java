package edu.neu.ccs.cs5004.eschaton.view.windowbuilders;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import edu.neu.ccs.cs5004.eschaton.model.Model;
import edu.neu.ccs.cs5004.eschaton.view.GameFrame;

public class UnitPanel extends GameFrame{

  BufferedImage buttonIcon = ImageIO.read(new File("/image/ship2.png"));

  public UnitPanel(Model model, String name, int width, int height) throws IOException {
    super(model, name, width, height);
  }

  public void makeUnitPanel(JPanel unitPanel) throws IOException {
    unitPanel.setBackground(Color.GREEN);
    unitPanel.setBounds(5, 310, 250, 300);
    unitPanel.setVisible(true);


    BufferedImage buttonIcon = ImageIO.read(getClass().getResource("/" +
        "image/ship2.png"));

    JButton jButton = new JButton(new ImageIcon(buttonIcon));
    jButton.setBorder(BorderFactory.createEmptyBorder());
    jButton.setContentAreaFilled(false);

//    unitPanel.setLayout(null);

    jButton.setBounds(50, 320, 90, 460);
    jButton.setActionCommand("Stuff");
//    jButton.setBorderPainted(false);
//    jButton.setContentAreaFilled(false);
    jButton.setCursor(Cursor.getPredefinedCursor(13));
    unitPanel.add(jButton);

  }

  protected void paintComponent(Graphics graphics){

  }
}
