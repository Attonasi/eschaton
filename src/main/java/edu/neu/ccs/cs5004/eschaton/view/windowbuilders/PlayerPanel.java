package edu.neu.ccs.cs5004.eschaton.view.windowbuilders;

import org.omg.CORBA.IRObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import edu.neu.ccs.cs5004.eschaton.model.player.Player;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.Deck;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.DeckItemInterface;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.panelbuttons.CardButton;

public class PlayerPanel extends JPanel implements Panel{

  private JPanel playerPanel;
  private UnitPanel unitPanel;
  private List<Player> players;
  private List<DeckItemInterface> playerHand;
  private int currentPlayer;
  private JTextField nameField;
  private JTextField raceField;
  private JTextField leadersField;
  private JTextField woodField;
  private JTextField foodField;
  private JTextField ironField;
  private JTextField stoneField;
  private JTextField goldField;
  private JTextField amalicumField;
  private JTextField bankField;

  public PlayerPanel(List<Player> list, UnitPanel unitPanel, int currentPlayer){
    playerPanel = new JPanel();
    this.players = list;
    this.currentPlayer = currentPlayer;
    this.playerHand = list.get(currentPlayer).getDeck().getHand();
    this.unitPanel = unitPanel;
    buildPanel();
  }

  /**
   * This is a getter for all of the panels used to build the map window. Each one will have a
   * parent JPanel and this will get it.
   *
   * @return JPanel
   */

  public JPanel getPanel() {
    return playerPanel;
  }

  public void buildPanel(){

    int down = 0;
    int across = 0;
    int bigFont = 20;
    int smallFont = 12;
    Color panelColor = new Color(160, 60, 75);

    playerPanel.setBackground(panelColor);
    playerPanel.setBounds(940, 5, 350, 650);
    playerPanel.setVisible(true);
    playerPanel.setLayout(null);
    Border blackline = BorderFactory.createLineBorder(Color.RED);
    playerPanel.setBorder(blackline);

    nameField = new JTextField();
    buildTextField(nameField, down, across, bigFont);
    nameField.setText("Player " + String.valueOf(currentPlayer + 1));
    nameField.setBackground(panelColor);
    down++;

    raceField = new JTextField();
    buildTextField(raceField, down, across, bigFont);
    raceField.setText(players.get(currentPlayer).getRace().getNameString());
    raceField.setBackground(panelColor);
    down++;

    leadersField = new JTextField();
    buildTextField(leadersField, down, across, bigFont);

    leadersField.setBackground(panelColor);
    down++;

    bankField = new JTextField();
    buildTextField(bankField, down, across, smallFont);
    bankField.setText("  Food      Wood          Iron       Stone       Gold   Amalicum");
    bankField.setBorder(null);
    bankField.setBackground(panelColor);
    down++;

    foodField = new JTextField();
    buildResourceField(foodField, down, across, bigFont);
    foodField.setText(String.valueOf(players.get(currentPlayer).getBank().getFood()));
    across++;

    woodField = new JTextField();
    buildResourceField(woodField, down, across, bigFont);
    woodField.setText(String.valueOf(players.get(currentPlayer).getBank().getWood()));
    across++;

    ironField = new JTextField();
    buildResourceField(ironField, down, across, bigFont);
    ironField.setText(String.valueOf(players.get(currentPlayer).getBank().getIron()));
    across++;

    stoneField = new JTextField();
    buildResourceField(stoneField, down, across, bigFont);
    stoneField.setText(String.valueOf(players.get(currentPlayer).getBank().getStone()));
    across++;

    goldField = new JTextField();
    buildResourceField(goldField, down, across, bigFont);
    goldField.setText(String.valueOf(players.get(currentPlayer).getBank().getGold()));
    across++;

    amalicumField = new JTextField();
    buildResourceField(amalicumField, down, across, bigFont);
    amalicumField.setText(String.valueOf(players.get(currentPlayer).getBank().getAmalicum()));
    across=0;
    down++;

    for(DeckItemInterface item : playerHand) {
      CardButton button = new CardButton(unitPanel, new Point(20, down * 40 + 20),
          item.getName());
      playerPanel.add(button.getButton());
      down++;
    }

    for (int i = 0; i< players.size(); i++){
      JTextField pText = new JTextField();
      pText.setBounds(i * 50 + 30, 600, 45, 45);
      pText.setText("   P "+ String.valueOf(i+1));
      pText.setBackground(panelColor);
      pText.setBorder(null);
      if(i == currentPlayer){ pText.setBorder(new LineBorder(Color.BLACK, 2)); }
      playerPanel.add(pText);
    }
  }

  private void buildResourceField(JTextField field, int down, int across, int font){
    field.setBounds(across *50 +30, down * 40+10, 30, 30);
    field.setVisible(true);
    field.setFont(new Font("Arial", Font.PLAIN, font));
    field.setHorizontalAlignment(JTextField.CENTER);
    playerPanel.add(field);
  }

  private void buildTextField(JTextField field, int down, int across, int font){
    field.setBounds(20 + across * 60, down *40 +20, 300, 30);
    field.setVisible(true);
    field.setFont(new Font("Arial", Font.PLAIN, font));
    field.setHorizontalAlignment(JTextField.CENTER);
    playerPanel.add(field);
  }

  public JTextField getNameField() {  return nameField;  }

  public JTextField getRaceField() {  return raceField;  }

  public JTextField getLeadersField() { return leadersField;  }

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

  @Override
  public String toString() {
    return "PlayerPanel{" +
        "playerPanel=" + playerPanel +
        ", unitPanel=" + unitPanel +
        ", players=" + players +
        ", currentPlayer=" + currentPlayer +
        ", nameField=" + nameField +
        ", raceField=" + raceField +
        ", leadersField=" + leadersField +
        ", woodField=" + woodField +
        ", foodField=" + foodField +
        ", ironField=" + ironField +
        ", stoneField=" + stoneField +
        ", goldField=" + goldField +
        ", amalicumField=" + amalicumField +
        '}';
  }
}
