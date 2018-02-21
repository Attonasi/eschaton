package edu.neu.ccs.cs5004.eschaton.view.windowbuilders;

import java.awt.*;

import javax.swing.*;

import edu.neu.ccs.cs5004.eschaton.model.Model;
import edu.neu.ccs.cs5004.eschaton.view.GameFrame;

public class UnitPanel extends GameFrame{

  public UnitPanel(Model model, String name, int width, int height) {
    super(model, name, width, height);
  }

  public static void makeUnitPanel(JPanel unitPanel){
    unitPanel.setBackground(Color.GREEN);
    unitPanel.setBounds(5, 310, 250, 300);
    unitPanel.setVisible(true);
//    unitPanel.setLayout(null);

    JButton jButton = new JButton("B");
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
