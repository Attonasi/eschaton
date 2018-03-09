package edu.neu.ccs.cs5004.eschaton.view.windowbuilders.panelbuttons;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

import edu.neu.ccs.cs5004.eschaton.view.GameFrame;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.PlayerPanel;

public class PlayerButton {

  private PlayerPanel playerPanel;
  private JButton button;
  private Point point;
  private int playerNumber;

  public PlayerButton(GameFrame gameFrame, PlayerPanel playerPanel, Point point, String name,
                      int playerNumber, Color panelColor) {
    this.playerPanel = playerPanel;
    this.button = new JButton(name);
    this.point = point;
    this.playerNumber = playerNumber;

    button.setBounds(point.x, point.y, 45, 45);
    button.setBorder(new LineBorder(Color.BLACK, 2));
    button.setBackground(panelColor);

    button.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) {   }

      @Override
      public void mousePressed(MouseEvent mouseEvent) {
        gameFrame.newPlayerPanel(playerNumber);
      }
      @Override
      public void mouseReleased(MouseEvent mouseEvent) {  }
      @Override
      public void mouseEntered(MouseEvent mouseEvent) { }
      @Override
      public void mouseExited(MouseEvent mouseEvent) { }
    });
  }

  public JButton getButton() {
    return button;
  }
}
