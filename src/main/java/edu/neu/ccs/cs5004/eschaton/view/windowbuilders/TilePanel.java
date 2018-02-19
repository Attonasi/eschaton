package edu.neu.ccs.cs5004.eschaton.view.windowbuilders;

import java.awt.*;

import javax.swing.*;

import edu.neu.ccs.cs5004.eschaton.model.Model;
import edu.neu.ccs.cs5004.eschaton.view.GameFrame;

public class TilePanel extends GameFrame{

  public TilePanel(Model model, String name, int width, int height) {
    super(model, name, width, height);
  }

  public static void makeTilePanel(JPanel tilePanel){
    tilePanel.setBackground(Color.BLUE);
    tilePanel.setBounds(5, 5, 300, 400);
    tilePanel.setVisible(true);


  }

  protected void paintComponent(Graphics graphics){

  }
}
