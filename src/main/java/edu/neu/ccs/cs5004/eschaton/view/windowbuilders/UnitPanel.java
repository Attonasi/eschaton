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
    unitPanel.setLayout(null);

    unitPanel.setBackground(Color.GREEN);

    unitPanel.setBounds(5, 310, 250, 300);
    unitPanel.setVisible(true);


    JButton jButton = new JButton("Button");
//    jButton.setLayout(null);
    jButton.setPreferredSize(new Dimension(100, 20));

    jButton.setBounds(10, 0, 20, 20);

//    jButton.setBorderPainted(false);
    jButton.setContentAreaFilled(false);
    jButton.setCursor(Cursor.getPredefinedCursor(13));
    unitPanel.add(jButton);

  }

  protected void paintComponent(Graphics graphics){

  }
}
