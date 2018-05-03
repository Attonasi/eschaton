package edu.neu.ccs.cs5004.eschaton.view.windowbuilders.panelbuttons;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import edu.neu.ccs.cs5004.eschaton.model.player.Player;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.Deck;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.DeckItemInterface;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.actions.ActionInterface;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.units.UnitInterface;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.village.Village;
import edu.neu.ccs.cs5004.eschaton.model.player.deck.deckitems.village.VillageInterface;
import edu.neu.ccs.cs5004.eschaton.view.GameFrame;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.DeckPanel;

public class CardButton {

  GameFrame gameFrame;
  private DeckPanel deckPanel;
  private JButton button;
  private Point point;
  private DeckItemInterface card;
  private Player player;


  public CardButton(DeckPanel deckPanel, Point point, int width, String actionName,
                    GameFrame gameFrame, DeckItemInterface card, Player player) {
    this.deckPanel = deckPanel;
    this.button = new JButton(actionName);
    this.point = point;
    this.gameFrame = gameFrame;
    this.card = card;
    this.player = player;

    button.setBounds(point.x, point.y, width, 25);

    button.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) {   }

      @Override
      public void mousePressed(MouseEvent mouseEvent) {
        callDeckPanelMethod(card);
      }
      @Override
      public void mouseReleased(MouseEvent mouseEvent) {  }
      @Override
      public void mouseEntered(MouseEvent mouseEvent) { }
      @Override
      public void mouseExited(MouseEvent mouseEvent) { }
    });
  }

  private void callDeckPanelMethod(DeckItemInterface card){
    if(card instanceof UnitInterface){
      deckPanel.showUnitInfo((UnitInterface) card);
      deckPanel.setCurrentPlayer(player);
    }else if (card instanceof ActionInterface){
      deckPanel.showActionInfo((ActionInterface) card);
      deckPanel.setCurrentPlayer(player);
    }else if (card instanceof VillageInterface){
      deckPanel.showVillageInfo((VillageInterface) card);
      deckPanel.setCurrentPlayer(player);
    }
  }

  public JButton getButton() {
    return button;
  }

 }
