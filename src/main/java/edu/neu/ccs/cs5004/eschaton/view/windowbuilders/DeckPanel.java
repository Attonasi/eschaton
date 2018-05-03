package edu.neu.ccs.cs5004.eschaton.view.windowbuilders;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;

import edu.neu.ccs.cs5004.eschaton.model.Model;
import edu.neu.ccs.cs5004.eschaton.model.map.Map;
import edu.neu.ccs.cs5004.eschaton.model.player.Player;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.actions.ActionInterface;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.units.UnitInterface;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.village.Village;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.village.VillageInterface;

public class DeckPanel extends JPanel implements Panel {

  private Model model;
  private Player currentPlayer;
  private JPanel deckPanel;
  private MapPanel mapPanel;
  private JTextField introField;

  private JTextField itemName;

  private JTextField circleLabelTop;
  private JTextField circleTop;
  private JTextField blockLabelTop;
  private JTextField blockTop;
  private JTextField toClockwiseLabelTop;
  private JTextField toClockwiseTop;

  private JTextField circleLabelMiddle;
  private JTextField circleMiddle;
  private JTextField blockLabelMiddle;
  private JTextField blockMiddle;
  private JTextField toClockwiseLabelMiddle;
  private JTextField toClockwiseMiddle;

//  private JTextField circleLabelBottom;
//  private JTextField circleBottom;
//  private JTextField blockLabelBottom;
//  private JTextField blockBottom;
//  private JTextField toClockwiseLabelBottom;
//  private JTextField toClockwiseBottom;

  private JTextField attackPower;
  private JTextField defensePower;
  private JTextField movement;
  private JTextField hitPoints;

  private JTextField food;
  private JTextField wood;
  private JTextField iron;
  private JTextField stone;
  private JTextField gold;
  private JTextField amalicum;

  private JButton fortifyButton;
  private JButton moveButton;
  private JButton attackButton;
  private JButton foundVillageButton;
  private JButton buildButton;
  private JButton harvestButton;
  private JButton playButton;

  private JTextArea description;
  private JTextField quote;

  private Color panelColor;

//  BufferedImage buttonIcon = ImageIO.read(new File("/image/ship2.png"));


  /**
   *  The DeckPanel displays information for the cards in a player's hand to the player and provides
   *  options to play them. There are 4 very different kinds of cards a player can have in their
   *  hand:
   *
   *  - Units
   *  - Villages
   *  - Leaders
   *  - Actions
   *
   *  This panel builds all of the Text boxes and buttons for each item then hides them all. When a
   *  player clicks on a card in their hand the proper information is loaded and displayed in the
   *  panel.
   */
  public DeckPanel(Model model) {

    this.model = model;

    this.deckPanel = new JPanel();
    this.panelColor = new Color(119,150,77);

    setUpPanel();

    introField = new JTextField();
    introField.setBounds(20,  20, 300, 30);
    introField.setVisible(true);
    introField.setFont(new Font("Arial", Font.PLAIN, 20));
    introField.setHorizontalAlignment(JTextField.CENTER);
    introField.setBackground(panelColor);
    introField.setBorder(null);
    introField.setText("Select an item from your hand");
    deckPanel.add(introField);

    this.itemName = newTextField(20, 20, 300, 30, 20,
        panelColor,  "Unit");

    this.circleLabelTop =     newTextField(50, 60, 30, 30, 16,
        panelColor, "C: ");
    this.circleTop =          newTextField(80, 60, 30, 30, 16,
        panelColor, " X ");
    this.blockLabelTop =      newTextField(140, 60, 30, 30, 16,
        panelColor, "B: ");
    this.blockTop =           newTextField(170, 60, 30, 30, 16,
        panelColor, " X ");
    this.toClockwiseLabelTop =newTextField(220, 60, 35, 30, 16,
        panelColor, "tC: ");
    this.toClockwiseTop =     newTextField(250, 60, 30, 30, 16,
        panelColor, " X ");

    this.fortifyButton =        newButton(30, 110, 120, 30, 13,
        panelColor, "Fortify");
    this.foundVillageButton =   newButton(180, 110, 120, 30, 13,
        panelColor, "Found Village");
    this.moveButton =           newButton(180, 250, 120, 30, 14,
        panelColor, "Move");
    this.attackButton = newButton(30, 250, 120, 30, 14,
        panelColor, "Attack");

    this.harvestButton =        newButton(250, 110, 85, 30, 14,
        panelColor, "Harvest");

    setButtonActions();


    this.attackPower =          newTextField(20, 160, 60, 30, 18,
        panelColor, "AP: ");
    this.defensePower =         newTextField(80, 160, 60, 30, 18,
        panelColor, "DP: ");
    this.movement =             newTextField(140, 160, 60, 30, 18,
        panelColor, "MV: ");
    this.hitPoints =           newTextField(220, 160, 100, 30, 18,
        panelColor, "HPs: ");

    this.food =          newTextField(20, 110, 40, 30, 16,
        panelColor, "F: ");
    this.wood =          newTextField(65, 110, 40, 30, 16,
        panelColor, "W: ");
    this.iron =          newTextField(110, 110, 40, 30, 16,
        panelColor, "I: ");
    this.stone =         newTextField(155, 110, 40, 30, 16,
        panelColor, "S: ");
    this.gold =          newTextField(200, 110, 40, 30, 16,
        panelColor, "G: ");
    this.amalicum =      newTextField(245, 110, 40, 30, 16,
        panelColor, "G: ");

    this.circleLabelMiddle =    newTextField(50, 210, 30, 30, 16,
        panelColor, "C: ");
    this.circleMiddle =         newTextField(80, 210, 30, 30, 16,
        panelColor, " X ");
    this.blockLabelMiddle =     newTextField(130, 210, 30, 30, 16,
        panelColor, "B: ");
    this.blockMiddle =          newTextField(160, 210, 30, 30, 16,
        panelColor, " X ");
    this.toClockwiseLabelMiddle=newTextField(210, 210, 35, 30, 16,
        panelColor, "tC: ");
    this.toClockwiseMiddle =    newTextField(240, 210, 30, 30, 16,
        panelColor, " X ");

//    this.circleLabelBottom =    newTextField(20, 210, 30, 30, 16,
//        panelColor, "C: ");
//    this.circleBottom =         newTextField(50, 210, 30, 30, 16,
//        panelColor, " X ");
//    this.blockLabelBottom =     newTextField(90, 210, 30, 30, 16,
//        panelColor, "B: ");
//    this.blockBottom =          newTextField(120, 210, 30, 30, 16,
//        panelColor, " X ");
//    this.toClockwiseLabelBottom=newTextField(170, 210, 35, 30, 16,
//        panelColor, "tC: ");
//    this.toClockwiseBottom =    newTextField(200, 210, 30, 30, 16,
//        panelColor, " X ");

    this.description =          newTextArea(30, 150, 300, 60, 16,
        panelColor, "A description of the effects of the action supplied by the action");
    description.setLineWrap(true);
    this.quote =                newTextField(30, 230, 250, 60, 16,
        panelColor, "Big long quote off the deck item");
  }

  public void setCurrentPlayer(Player player){ this.currentPlayer = player; }

  protected void hideAll(){
    introField.setVisible(true);

    itemName.setVisible(false);

    circleLabelTop.setVisible(false);
    circleTop.setVisible(false);
    blockLabelTop.setVisible(false);
    blockTop.setVisible(false);
    toClockwiseLabelTop.setVisible(false);
    toClockwiseTop.setVisible(false);

    circleLabelMiddle.setVisible(false);
    circleMiddle.setVisible(false);
    blockLabelMiddle.setVisible(false);
    blockMiddle.setVisible(false);
    toClockwiseLabelMiddle.setVisible(false);
    toClockwiseMiddle.setVisible(false);

//    circleLabelBottom.setVisible(false);
//    circleBottom.setVisible(false);
//    blockLabelBottom.setVisible(false);
//    blockBottom.setVisible(false);
//    toClockwiseLabelBottom.setVisible(false);
//    toClockwiseBottom.setVisible(false);

    attackPower.setVisible(false);
    defensePower.setVisible(false);
    movement.setVisible(false);
    hitPoints.setVisible(false);

    food.setVisible(false);
    wood.setVisible(false);
    iron.setVisible(false);
    stone.setVisible(false);
    gold.setVisible(false);
    amalicum.setVisible(false);

    fortifyButton.setVisible(false);
    moveButton.setVisible(false);
    attackButton.setVisible(false);
    foundVillageButton.setVisible(false);
//    buildButton.setVisible(false);
    harvestButton.setVisible(false);
//    playButton.setVisible(false);
//
    description.setVisible(false);
    quote.setVisible(false);
  }

  public void showUnitInfo(UnitInterface unit){
    hideAll();

    itemName.setText(unit.getName());
    attackPower.setText("AP: " + String.valueOf(unit.getAttackPower()));
    defensePower.setText("DP: " + String.valueOf(unit.getDefensePower()));
    movement.setText("MV: " + String.valueOf(unit.getMovement()));
    hitPoints.setText("HPs: " + String.valueOf(unit.getCurrentHitPoints())+"/"
            +String.valueOf(unit.getTotalHitPoints()));

    circleTop.setText(String.valueOf(unit.getLocation().getCircle()));
    blockTop.setText(String.valueOf(unit.getLocation().getBlock()));
    toClockwiseTop.setText(String.valueOf(unit.getLocation().getClockwise()));

    itemName.setVisible(true);

    circleLabelTop.setVisible(true);
    circleTop.setVisible(true);
    blockLabelTop.setVisible(true);
    blockTop.setVisible(true);
    toClockwiseLabelTop.setVisible(true);
    toClockwiseTop.setVisible(true);

    fortifyButton.setVisible(true);
    foundVillageButton.setVisible(true);

    circleLabelMiddle.setVisible(true);
    circleMiddle.setVisible(true);
    blockLabelMiddle.setVisible(true);
    blockMiddle.setVisible(true);
    toClockwiseLabelMiddle.setVisible(true);
    toClockwiseMiddle.setVisible(true);

    moveButton.setVisible(true);

//    circleLabelBottom.setVisible(true);
//    circleBottom.setVisible(true);
//    blockLabelBottom.setVisible(true);
//    blockBottom.setVisible(true);
//    toClockwiseLabelBottom.setVisible(true);
//    toClockwiseBottom.setVisible(true);

    attackButton.setVisible(true);

    attackPower.setVisible(true);
    defensePower.setVisible(true);
    movement.setVisible(true);
    hitPoints.setVisible(true);
  }

  public void showActionInfo(ActionInterface action){
    hideAll();
    itemName.setText(action.getName());
    itemName.setVisible(true);

    description.setText(action.getDescription());
    description.setVisible(true);

    food.setText(String.valueOf(action.getCost()[0]));
    wood.setText(String.valueOf(action.getCost()[1]));
    iron.setText(String.valueOf(action.getCost()[2]));
    stone.setText(String.valueOf(action.getCost()[3]));
    gold.setText(String.valueOf(action.getCost()[4]));
    amalicum.setText(String.valueOf(action.getCost()[5]));

    food.setVisible(true);
    wood.setVisible(true);
    iron.setVisible(true);
    stone.setVisible(true);
    gold.setVisible(true);
    amalicum.setVisible(true);
  }

  public void showVillageInfo(VillageInterface village){
    hideAll();
    itemName.setText(village.getName());
    itemName.setVisible(true);

    circleTop.setText(String.valueOf(village.getCell().getCellPosition().getCircle()));
    blockTop.setText(String.valueOf(village.getCell().getCellPosition().getBlock()));
    toClockwiseTop.setText(String.valueOf(village.getCell().getCellPosition().getClockwise()));

    food.setText(String.valueOf(village.getHarvestBounty()[0]));
    wood.setText(String.valueOf(village.getHarvestBounty()[1]));
    iron.setText(String.valueOf(village.getHarvestBounty()[2]));
    stone.setText(String.valueOf(village.getHarvestBounty()[3]));
    gold.setText(String.valueOf(village.getHarvestBounty()[4]));

    circleLabelTop.setVisible(true);
    circleTop.setVisible(true);
    blockLabelTop.setVisible(true);
    blockTop.setVisible(true);
    toClockwiseLabelTop.setVisible(true);
    toClockwiseTop.setVisible(true);

    food.setVisible(true);
    wood.setVisible(true);
    iron.setVisible(true);
    stone.setVisible(true);
    gold.setVisible(true);

    harvestButton.setVisible(true);
  }


  private void setUpPanel(){
    deckPanel.setLayout(null);
    deckPanel.setBackground(panelColor);
    deckPanel.setBounds(5, 340, 345, 315);
    deckPanel.setVisible(true);
    deckPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
  }

  private JTextField newTextField(int xPos, int yPos, int width, int height, int fontSize,
                                  Color color, String fieldText){
    JTextField field = new JTextField();
    field.setBounds(xPos,  yPos, width, height);
    field.setVisible(false);
    field.setFont(new Font("Arial", Font.PLAIN, fontSize));
    field.setHorizontalAlignment(JTextField.CENTER);
    field.setBackground(color);
    field.setBorder(null);
    field.setText(fieldText);
    deckPanel.add(field);

    return field;
  }

  private JTextArea newTextArea(int xPos, int yPos, int width, int height, int fontSize,
                                  Color color, String fieldText){
    JTextArea field = new JTextArea();
    field.setBounds(xPos,  yPos, width, height);
    field.setVisible(false);
    field.setFont(new Font("Arial", Font.PLAIN, fontSize));
    field.setBackground(color);
    field.setText(fieldText);
    deckPanel.add(field);

    return field;
  }


  private JButton newButton(int xPos, int yPos, int width, int height, int fontSize,
                            Color color, String buttonText){
    JButton button = new JButton(buttonText);
    button.setBounds(xPos,  yPos, width, height);
    button.setVisible(false);
    button.setFont(new Font("Arial", Font.PLAIN, fontSize));
    button.setHorizontalAlignment(JTextField.CENTER);
    button.setBackground(color);

    deckPanel.add(button);
    return button;
  }

  public void testFunction(){
  }

  /**
   * This is a getter for all of the panels used to build the map window. Each one will have a
   * parent JPanel and this will get it.
   *
   * @return JPanel
   */

  public JPanel getPanel() {
    return deckPanel;
  }

  public Color getPanelColor() {
    return panelColor;
  }

  public JTextField getItemName() {
    return itemName;
  }

  public JTextField getCircleTop() {
    return circleTop;
  }

  public JTextField getBlockTop() {
    return blockTop;
  }

  public JTextField getToClockwiseTop() {
    return toClockwiseTop;
  }

  public JTextField getCircleMiddle() {
    return circleMiddle;
  }

  public JTextField getBlockMiddle() {
    return blockMiddle;
  }

  public JTextField getToClockwiseMiddle() {
    return toClockwiseMiddle;
  }

//  public JTextField getCircleBottom() {
//    return circleBottom;
//  }
//
//  public JTextField getBlockBottom() {
//    return blockBottom;
//  }
//
//  public JTextField getToClockwiseBottom() {
//    return toClockwiseBottom;
//  }

  public JTextField getAttackPower() {
    return attackPower;
  }

  public JTextField getDefensePower() {
    return defensePower;
  }

  public JTextField getMovement() {
    return movement;
  }

  public JTextField getHitPoints() {
    return hitPoints;
  }

  public JTextField getHarvestFood() {
    return food;
  }

  public JTextField getHarvestWood() {
    return wood;
  }

  public JTextField getHarvestIron() {
    return iron;
  }

  public JTextField getHarvestStone() {
    return stone;
  }

  public JTextField getHarvestGold() {
    return gold;
  }

  /**
   * Each panel will have it's own build panel method that adds buttons and components to that
   * JPanel object. This will be called by the constructor.
   */

  public JTextField getItemNameField() { return introField; }

  private void setButtonActions() {

    attackButton.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) { }
      @Override
      public void mousePressed(MouseEvent mouseEvent) {
        System.out.println(currentPlayer.getPlayerNumber() + " Attack!");
      }
      @Override
      public void mouseReleased(MouseEvent mouseEvent) {  }
      @Override
      public void mouseEntered(MouseEvent mouseEvent) {  }
      @Override
      public void mouseExited(MouseEvent mouseEvent) {  }
    });

    moveButton.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) { }
      @Override
      public void mousePressed(MouseEvent mouseEvent) {
        System.out.println(currentPlayer.getPlayerNumber() + " MOVE!");
      }
      @Override
      public void mouseReleased(MouseEvent mouseEvent) {  }
      @Override
      public void mouseEntered(MouseEvent mouseEvent) {  }
      @Override
      public void mouseExited(MouseEvent mouseEvent) {  }
    });

    fortifyButton.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) { }
      @Override
      public void mousePressed(MouseEvent mouseEvent) {
        System.out.println(currentPlayer.getPlayerNumber() + " Fortify!"); }
      @Override
      public void mouseReleased(MouseEvent mouseEvent) {  }
      @Override
      public void mouseEntered(MouseEvent mouseEvent) {  }
      @Override
      public void mouseExited(MouseEvent mouseEvent) {  }
    });

    foundVillageButton.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) { }
      @Override
      public void mousePressed(MouseEvent mouseEvent) {
        System.out.println(currentPlayer.getPlayerNumber() +" Found!");
      }
      @Override
      public void mouseReleased(MouseEvent mouseEvent) {  }
      @Override
      public void mouseEntered(MouseEvent mouseEvent) {  }
      @Override
      public void mouseExited(MouseEvent mouseEvent) {  }
    });

    harvestButton.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) { }
      @Override
      public void mousePressed(MouseEvent mouseEvent) {
        System.out.println(currentPlayer.getPlayerNumber() + " Harvest!"); }
      @Override
      public void mouseReleased(MouseEvent mouseEvent) {  }
      @Override
      public void mouseEntered(MouseEvent mouseEvent) {  }
      @Override
      public void mouseExited(MouseEvent mouseEvent) {  }
    });
  }

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
