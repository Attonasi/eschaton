package edu.neu.ccs.cs5004.eschaton.view.windowbuilders;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;

public class TilePanel extends JPanel implements Panel{

  private JPanel tilePanel;
  public  JTextField circleField;
  public  JTextField blockField;
  public  JTextField toClockwiseField;
  public  JTextField woodField;
  public  JTextField foodField;
  public  JTextField ironField;
  public  JTextField stoneField;
  public  JTextField goldField;

  public TilePanel() {
    tilePanel = new JPanel();
    buildPanel();
  }

  /**
   * This is a getter for all of the panels used to build the map window. Each one will have a
   * parent JPanel and this will get it.
   *
   * @return JPanel
   */

  public JPanel getPanel() {
    return tilePanel;
  }

  public void buildPanel(){

    int number = 0;

    tilePanel.setBackground(Color.BLUE);
    tilePanel.setBounds(5, 5, 250, 300);
    tilePanel.setVisible(true);
    tilePanel.setLayout(null);
    Border blackline = BorderFactory.createLineBorder(Color.RED);
    tilePanel.setBorder(blackline);

    circleField = new JTextField();
    buildCoordinateField(circleField, number);
    number++;

    blockField = new JTextField();
    buildCoordinateField(blockField, number);
    number++;

    toClockwiseField = new JTextField();
    buildCoordinateField(toClockwiseField, number);
    number = 0;

    foodField = new JTextField();
    buildResourceField(foodField, number);
    number++;

    woodField = new JTextField();
    buildResourceField(woodField, number);
    number++;

    ironField = new JTextField();
    buildResourceField(ironField, number);
    number++;

    stoneField = new JTextField();
    buildResourceField(stoneField, number);
    number++;

    goldField = new JTextField();
    buildResourceField(goldField, number);
    number++;
  }

  private void buildResourceField(JTextField field, int number){
    field.setBounds(140, number * 30 + 80, 40, 30);
    field.setVisible(true);
    field.setFont(new Font("Arial", Font.PLAIN, 20));
    field.setHorizontalAlignment(JTextField.CENTER);
    tilePanel.add(field);
  }

  private void buildCoordinateField(JTextField field, int number){
    field.setBounds(20 + number*60, 20, 40, 30);
    field.setVisible(true);
    field.setFont(new Font("Arial", Font.PLAIN, 20));
    field.setHorizontalAlignment(JTextField.CENTER);
    tilePanel.add(field);
  }

  public JTextField getCircleField() {  return circleField;  }

  public JTextField getBlockField() {  return blockField;  }

  public JTextField getToClockwiseField() { return toClockwiseField;  }

  public JTextField getWoodField() { return woodField;  }

  public JTextField getFoodField() { return foodField;  }

  public JTextField getIronField() { return ironField;  }

  public JTextField getStoneField() {  return stoneField;  }

  public JTextField getGoldField() { return goldField;  }

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
