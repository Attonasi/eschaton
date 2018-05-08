package edu.neu.ccs.cs5004.eschaton.view.windowbuilders;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import edu.neu.ccs.cs5004.eschaton.model.Model;
import edu.neu.ccs.cs5004.eschaton.model.player.Player;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.DeckItemInterface;
import edu.neu.ccs.cs5004.eschaton.view.GameFrame;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.panelbuttons.CardButton;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.panelbuttons.PlayerButton;

public class PlayerPanel extends JPanel implements Panel{

  private int counter = 0;
  private Model model;

  private int bigFont = 20;
  private int smallFont = 12;
  private int buttonfont = 12;
  private Color panelColor = new Color(160, 60, 75);

  private JPanel playerPanel;
  private DeckPanel deckPanel;
  private GameFrame gameFrame;

  private JTextField nameField;
  private JTextField raceField;
  private JTextField leadersField;
  private JTextField bankField;

  private JTextField foodField;
  private JTextField woodField;
  private JTextField ironField;
  private JTextField stoneField;
  private JTextField goldField;
  private JTextField amalicumField;

  private JTextField deckLabel;
  private JTextField deckSize;
  private JTextField discardLabel;
  private JTextField discardSize;

  private List<CardButton> cardButtons = new ArrayList<>();

  public PlayerPanel(GameFrame gameFrame, Model model){

    this.model = model;

    playerPanel = new JPanel();
    this.gameFrame = gameFrame;
    this.deckPanel = gameFrame.getDeckPanel();

    buildPanel();

    this.nameField = new JTextField();
    buildTextField(nameField, 20, 20, bigFont, 100, 30, panelColor,"Player");

    this.raceField = new JTextField();
    buildTextField(raceField, 50, 20, bigFont, 100, 30, panelColor,"Race");

    this.leadersField = new JTextField();
    buildTextField(leadersField, 80, 20, bigFont, 100, 30, panelColor,"Leader");

    this.bankField = new JTextField();
    buildTextField(bankField, 110, 10, smallFont, 300, 30, panelColor,
        "  Food       Wood         Iron       Stone       Gold   Amalicum");

    this.foodField = new JTextField();
    buildResourceField(foodField, 140, 20, bigFont, 30, 30,
        new Color(255,255,255),"0");

    this.woodField = new JTextField();
    buildResourceField(woodField, 140, 70, bigFont, 30, 30,
        new Color(255,255,255),"0");

    this.ironField = new JTextField();
    buildResourceField(ironField, 140, 120, bigFont, 30, 30,
        new Color(255,255,255),"0");

    this.stoneField = new JTextField();
    buildResourceField(stoneField, 140, 170, bigFont, 30, 30,
        new Color(255,255,255),"0");

    this.goldField = new JTextField();
    buildResourceField(goldField, 140, 220, bigFont, 30, 30,
        new Color(255,255,255),"0");

    this.amalicumField = new JTextField();
    buildResourceField(amalicumField, 140, 270, bigFont, 30, 30,
        new Color(255,255,255),"0");

    this.deckLabel = new JTextField();
    buildTextField(deckLabel, 180, 20, 16, 110, 30, panelColor,"Cards in Deck: ");

    this.deckSize = new JTextField();
    buildResourceField(deckSize, 180, 120, bigFont, 30, 30, panelColor,"0");

    this.discardLabel = new JTextField();
    buildTextField(discardLabel, 180, 160, 16, 125, 30, panelColor,"Cards in Discard: ");

    this.discardSize = new JTextField();
    buildResourceField(discardSize, 180, 280, bigFont, 30, 30, panelColor,"0");

    System.out.println("playerPanel counter " + counter++);
    buildHand(model.getPlayers().get(model.getPlayerIndex()).getDeck().getHand());
    makePlayerButtons(model.getPlayers());
  }

  public void buildPanel() {
    playerPanel.setLayout(null);
    playerPanel.setBackground(panelColor);
    playerPanel.setBounds(930, 5, 350, 650);
    playerPanel.setVisible(true);
    playerPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
  }
  public void changePlayer(Integer index){

    model.setPlayerIndex(index);
    System.out.println("Index = " + index);
    deckPanel.hideAll();

    nameField.setText("Player " + String.valueOf(model.getPlayers().get(index).getPlayerNumber()+1));
    raceField.setText(model.getPlayers().get(index).getRace().getNameString());
    leadersField.setText(model.getPlayers().get(index).getLeader().getLeader());

    foodField.setText(String.valueOf(model.getPlayers().get(index).getBank().getFood()));
    woodField.setText(String.valueOf(model.getPlayers().get(index).getBank().getWood()));
    ironField.setText(String.valueOf(model.getPlayers().get(index).getBank().getIron()));
    stoneField.setText(String.valueOf(model.getPlayers().get(index).getBank().getStone()));
    goldField.setText(String.valueOf(model.getPlayers().get(index).getBank().getGold()));
    amalicumField.setText(String.valueOf(model.getPlayers().get(index).getBank().getAmalicum()));

    deckSize.setText(String.valueOf(model.getPlayers().get(index).getDeck().getDeck().size()));
    discardSize.setText(String.valueOf(model.getPlayers().get(index).getDeck().getDiscard().size()));

    buildHand(model.getPlayers().get(index).getDeck().getHand());
  }

  public void buildHand(List<DeckItemInterface> playerHand){

    for(CardButton b: cardButtons){

      b.getButton().setVisible(false);
      playerPanel.remove(b.getButton());
    }
    cardButtons.clear();
    int x, width;
    if (playerHand.size() < 10 ){
      x = 50;
      width = 200;
    }else {
      x = 10;
      width = 140;
    }
    int down = 220;
    int count = 1;
    for(DeckItemInterface item : playerHand) {
      CardButton button = new CardButton(deckPanel, new Point(x, down), width,
          item.getName(), gameFrame, item, model.getPlayers().get(model.getPlayerIndex()));

      playerPanel.add(button.getButton());
      cardButtons.add(button);

      if(count % 11 == 0) { x += 145; }
      down+=30;
      count++;
    }
  }

  public void makePlayerButtons(List<Player> list){
    Integer index = 0;
    Point point = new Point(20, 600);
    for(Player p: list){
      playerPanel.add(new PlayerButton(this, point, p, panelColor).getButton());
      point.x += 50;
    }
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

   private void buildResourceField(JTextField field, int down, int across, int font, int width,
                                  int height, Color panelColor, String string){
    field.setBounds(across , down,  width, height);
    field.setVisible(true);
    field.setFont(new Font("Arial", Font.PLAIN, font));
    field.setHorizontalAlignment(JTextField.CENTER);
    field.setBorder(null);
    field.setText(string);
    field.setBackground(panelColor);
    playerPanel.add(field);
  }

  private void buildTextField(JTextField field, int down, int across, int font, int width,
                              int height, Color panelColor, String string){
    field.setBounds(across, down, width, height);
    field.setVisible(true);
    field.setFont(new Font("Arial", Font.PLAIN, font));
    field.setHorizontalAlignment(JTextField.LEFT);
    field.setAlignmentX(CENTER_ALIGNMENT);
    field.setBorder(null);
    field.setText(string);
    field.setBackground(panelColor);
    playerPanel.add(field);
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
