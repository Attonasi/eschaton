package edu.neu.ccs.cs5004.eschaton.view.windowbuilders;

import java.awt.*;
import javax.swing.*;

import edu.neu.ccs.cs5004.eschaton.model.Model;
import edu.neu.ccs.cs5004.eschaton.view.GameFrame;

public class MapPanel extends GameFrame{

  private JButton jButton;

  public MapPanel(Model model, String name, int width, int height) {
    super(model, name, width, height);


  }

  public static void makeMapPanel(JPanel mapPanel){
    mapPanel.setBackground(Color.DARK_GRAY);
    mapPanel.setBounds(255, 5, 700, 700);
    mapPanel.setVisible(true);



  }

  protected void paintComponent(Graphics graphics){
//    MapPrinter.printMap(graphics, model.getMap());
  }
}
