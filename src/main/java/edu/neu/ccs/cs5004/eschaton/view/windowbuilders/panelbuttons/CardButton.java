package edu.neu.ccs.cs5004.eschaton.view.windowbuilders.panelbuttons;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.UnitPanel;

public class CardButton {

  private UnitPanel unitPanel;
  private JButton button;
  private Point point;


  public CardButton(UnitPanel unitPanel, Point point, String actionName) {
    this.unitPanel = unitPanel;
    this.button = new JButton(actionName);
    this.point = point;

    button.setBounds(point.x, point.y, 250, 30);

    button.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) {   }

      @Override
      public void mousePressed(MouseEvent mouseEvent) {
        unitPanel.getUnitNameField().setText(actionName);
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
