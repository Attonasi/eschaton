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
    unitPanel.setBounds(5, 410, 300, 400);
    unitPanel.setVisible(true);
    JButton jButton = new JButton("Button");

    unitPanel.add(jButton);

  }

  protected void paintComponent(Graphics graphics){

  }
}
