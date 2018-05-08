package edu.neu.ccs.cs5004.eschaton.view.windowbuilders;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;

public class TilePanel extends JPanel implements Panel{

  private JPanel tilePanel;
  private JTextField circleField = new JTextField();
  private JTextField circleLabel = new JTextField();
  private JTextField blockField = new JTextField();
  private JTextField blockLabel = new JTextField();
  private JTextField toClockwiseField = new JTextField();
  private JTextField toClockwiseLabel = new JTextField();
  private JTextField woodField = new JTextField();
  private JTextField foodField = new JTextField();
  private JTextField ironField = new JTextField();
  private JTextField stoneField = new JTextField();
  private JTextField goldField = new JTextField();
  private JTextField woodLabel = new JTextField();
  private JTextField foodLabel = new JTextField();
  private JTextField ironLabel = new JTextField();
  private JTextField stoneLabel = new JTextField();
  private JTextField goldLabel = new JTextField();
  private JTextField unit1 = new JTextField();
  private JTextField unit2 = new JTextField();
  private JTextField unit3 = new JTextField();
  private JTextField unit4 = new JTextField();
  private JTextField unit5 = new JTextField();
  private JTextField unitLabel = new JTextField();



  int valueSize = 30;
  int labelXSize = 104;
  int labelYSize = 30;
  int labelFontSize = 17;
  int valueFontSize = 20;
  Color panelColor = new Color(35, 150, 150);

  public TilePanel() {
    tilePanel = new JPanel();
    buildPanel();

    buildTextField(circleLabel, 10, 15, "Circle");
    buildTextField(circleField, 52, 40);
    buildTextField(blockLabel, 120, 15, "Block");
    buildTextField(blockField, 162, 40);
    buildTextField(toClockwiseLabel, 230, 15, "ToClockWise");
    buildTextField(toClockwiseField, 272, 40);
    buildTextField(foodLabel, 181, 100, "Food:");
    buildTextField(foodField, 272, 100);
    buildTextField(woodLabel, 181, 140, "Wood:");
    buildTextField(woodField, 272, 140);
    buildTextField(ironLabel, 181, 180, "Iron:");
    buildTextField(ironField, 272, 180);
    buildTextField(stoneLabel, 181, 220, "Stone:");
    buildTextField(stoneField, 272, 220);
    buildTextField(goldLabel, 181, 260, "Gold:");
    buildTextField(goldField, 272, 260);

    buildTextField(unitLabel, 41, 70, "Units in Tile");
    buildTextField(unit1, 41, 105, "x");
    buildTextField(unit2, 41, 140, "x");
    buildTextField(unit3, 41, 175, "x");
    buildTextField(unit4, 41, 210, "x");
    buildTextField(unit5, 41, 245, "x");



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

    tilePanel.setBackground(panelColor);
    tilePanel.setBounds(5, 5, 345, 320);
    tilePanel.setVisible(true);
    tilePanel.setLayout(null);
    tilePanel.setBorder(BorderFactory.createLineBorder(Color.RED));
  }

  private void buildTextField(JTextField field, int x, int y, String text){
    field.setBounds(x, y, labelXSize, labelYSize);
    field.setVisible(true);
    field.setFont(new Font("Arial", Font.PLAIN, labelFontSize));
    field.setHorizontalAlignment(JTextField.CENTER);
    field.setText(text);
    field.setBackground(panelColor);
    field.setBorder(null);
    tilePanel.add(field);
  }

  private void buildTextField(JTextField field, int x, int y){
    field.setBounds(x, y, valueSize, valueSize);
    field.setVisible(true);
    field.setFont(new Font("Arial", Font.PLAIN, valueFontSize));
    field.setHorizontalAlignment(JTextField.CENTER);
    field.setBackground(panelColor);
    field.setBorder(null);
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

  public JTextField getUnit1() { return unit1; }

  public JTextField getUnit2() { return unit2; }

  public JTextField getUnit3() { return unit3; }

  public JTextField getUnit4() { return unit4; }

  public JTextField getUnit5() { return unit5; }

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
