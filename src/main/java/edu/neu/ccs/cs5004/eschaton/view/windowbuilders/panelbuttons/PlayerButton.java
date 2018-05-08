package edu.neu.ccs.cs5004.eschaton.view.windowbuilders.panelbuttons;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

import edu.neu.ccs.cs5004.eschaton.model.player.Player;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.PlayerPanel;

public class PlayerButton {

  private JButton button;
  private Point point;
  private Player player;
  private PlayerPanel panel;
  private Integer index;

  public PlayerButton(PlayerPanel panel, Point point, Player player, Color panelColor) {
    this.button = new JButton("P"+String.valueOf(player.getPlayerNumber()+1));
    this.point = point;
    this.player = player;
    this.panel = panel;
//    this.index = index;

    button.setBounds(point.x, point.y, 45, 45);
    button.setBorder(new LineBorder(Color.BLACK, 2));
    button.setBackground(panelColor);

    button.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) {   }

      @Override
      public void mousePressed(MouseEvent mouseEvent) {

        panel.changePlayer(player.getPlayerNumber());
      }
      @Override
      public void mouseReleased(MouseEvent mouseEvent) {  }
      @Override
      public void mouseEntered(MouseEvent mouseEvent) { }
      @Override
      public void mouseExited(MouseEvent mouseEvent) { }
    });
  }

  public JButton getButton(){
    return button;
  }
}
