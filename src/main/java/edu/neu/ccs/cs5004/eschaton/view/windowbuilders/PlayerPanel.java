package edu.neu.ccs.cs5004.eschaton.view.windowbuilders;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;

import edu.neu.ccs.cs5004.eschaton.model.player.Player;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.DeckItemInterface;
import edu.neu.ccs.cs5004.eschaton.view.GameFrame;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.panelbuttons.CardButton;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.panelbuttons.PlayerButton;

public class PlayerPanel extends JPanel implements Panel{

  private JPanel playerPanel;
  private DeckPanel deckPanel;
  private List<Player> players;
  private List<DeckItemInterface> playerHand;
  private int currentPlayer;
  private GameFrame gameFrame;

  public PlayerPanel(List<Player> list, DeckPanel deckPanel, int currentPlayer, GameFrame gameFrame){
    playerPanel = new JPanel();
    this.players = list;
    this.currentPlayer = currentPlayer;
    this.playerHand = list.get(currentPlayer).getDeck().getHand();
    this.deckPanel = deckPanel;
    this.gameFrame = gameFrame;
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

    JTextField nameField = new JTextField();
    buildTextField(nameField, 20, 20, bigFont, 100, 30, panelColor,
        "Player " + String.valueOf(currentPlayer + 1));


    JTextField raceField = new JTextField();
    buildTextField(raceField, 50, 20, bigFont, 100, 30, panelColor,
        players.get(currentPlayer).getRace().getNameString());


    JTextField leadersField = new JTextField();
    buildTextField(leadersField, 80, 20, bigFont, 100, 30, panelColor, "");


    JTextField bankField = new JTextField();
    buildTextField(bankField, 110, 10, smallFont, 300, 30, panelColor,
        "  Food       Wood         Iron       Stone       Gold   Amalicum");


    JTextField foodField = new JTextField();
    buildResourceField(foodField, 140, 20, bigFont, 30, 30,
        new Color(255,255,255),
        String.valueOf(players.get(currentPlayer).getBank().getFood()));
    across++;

    JTextField woodField = new JTextField();
    buildResourceField(woodField, 140, 70, bigFont, 30, 30,
        new Color(255,255,255),
        String.valueOf(players.get(currentPlayer).getBank().getWood()));
    across++;

    JTextField ironField = new JTextField();
    buildResourceField(ironField, 140, 120, bigFont, 30, 30,
        new Color(255,255,255),
        String.valueOf(players.get(currentPlayer).getBank().getIron()));
    across++;

    JTextField stoneField = new JTextField();
    buildResourceField(stoneField, 140, 170, bigFont, 30, 30,
        new Color(255,255,255),
        String.valueOf(players.get(currentPlayer).getBank().getStone()));
    across++;

    JTextField goldField = new JTextField();
    buildResourceField(goldField, 140, 220, bigFont, 30, 30,
        new Color(255,255,255),
        String.valueOf(players.get(currentPlayer).getBank().getGold()));
    across++;

    JTextField  amalicumField = new JTextField();
    buildResourceField(amalicumField, 140, 270, bigFont, 30, 30,
        new Color(255,255,255),
        String.valueOf(players.get(currentPlayer).getBank().getAmalicum()));
    across=0;


    JTextField deckLabel = new JTextField();
    buildTextField(deckLabel, 180, 20, 16, 110, 30, panelColor,
        "Cards in Deck: ");
    across=2;

    JTextField  deckSize = new JTextField();
    buildResourceField(deckSize, 180, 120, bigFont, 30, 30, panelColor,
        String.valueOf(players.get(currentPlayer).getDeck().getDeck().size()));
    across++;

    JTextField discardLabel = new JTextField();
    buildTextField(discardLabel, 180, 160, 16, 125, 30, panelColor,
        "Cards in Discard: ");
    across++;

    JTextField  discardSize = new JTextField();
    buildResourceField(discardSize, 180, 280, bigFont, 30, 30, panelColor,
        String.valueOf(players.get(currentPlayer).getDeck().getDiscard().size()));


    for(DeckItemInterface item : playerHand) {
      CardButton button = new CardButton(deckPanel, new Point(20, down * 35 + 220),
          item.getName());
      playerPanel.add(button.getButton());
      down++;
    }

    for (int i = 0; i< players.size(); i++){
      PlayerButton pText = new PlayerButton(gameFrame, this,
          new Point(i * 50 + 30, 600), " P "+ String.valueOf(i+1), i, panelColor);

      playerPanel.add(pText.getButton());
    }
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

  @Override
  public String toString() {
    return "PlayerPanel{" +
        "playerPanel=" + playerPanel +
        ", deckPanel=" + deckPanel +
        ", players=" + players +
        ", currentPlayer=" + currentPlayer +
        '}';
  }
}
