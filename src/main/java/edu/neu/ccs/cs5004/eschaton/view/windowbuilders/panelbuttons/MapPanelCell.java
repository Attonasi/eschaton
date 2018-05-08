package edu.neu.ccs.cs5004.eschaton.view.windowbuilders.panelbuttons;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import edu.neu.ccs.cs5004.eschaton.model.map.cell.Cell;
import edu.neu.ccs.cs5004.eschaton.model.map.cell.cellposition.CellPosition;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.DeckPanel;
import edu.neu.ccs.cs5004.eschaton.view.windowbuilders.TilePanel;

import static edu.neu.ccs.cs5004.eschaton.view.windowbuilders.MapPanel.X_OFFSET;
import static edu.neu.ccs.cs5004.eschaton.view.windowbuilders.MapPanel.Y_OFFSET;

public class MapPanelCell implements MapPanelCellIInterface{

  private Cell cell;
  private JButton button;
  private DeckPanel deckPanel;
  private TilePanel tilePanel;


  public MapPanelCell(Cell cell, DeckPanel deckPanel, TilePanel tilePanel) {

    this.button = new JButton("x");
    this.deckPanel = deckPanel;
    this.tilePanel = tilePanel;

    this.cell = cell;

    button.setBounds(cell.getPoint().x-X_OFFSET, cell.getPoint().y-Y_OFFSET, 30, 30);
    button.setBackground(cell.getCellColor());
    button.setContentAreaFilled(true);
    button.setFont(new Font("Arial", Font.PLAIN, 5));

    button.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) {   }

      @Override
      public void mousePressed(MouseEvent mouseEvent) {
        tilePanel.getWoodField().setText(String.valueOf(cell.getContents().getWood()));
        tilePanel.getFoodField().setText(String.valueOf(cell.getContents().getFood()));
        tilePanel.getIronField().setText(String.valueOf(cell.getContents().getIron()));
        tilePanel.getStoneField().setText(String.valueOf(cell.getContents().getStone()));
        tilePanel.getGoldField().setText(String.valueOf(cell.getContents().getGold()));

        tilePanel.getCircleField().setText(cell.getCellPosition().getCircle().toString());
        tilePanel.getBlockField().setText(cell.getCellPosition().getBlock().toString());
        tilePanel.getToClockwiseField().setText(cell.getCellPosition().getClockwise().toString());

        tilePanel.getUnit1().setText(cell.getUnitNameAtIndex(0));
        tilePanel.getUnit2().setText(cell.getUnitNameAtIndex(1));
        tilePanel.getUnit3().setText(cell.getUnitNameAtIndex(2));
        tilePanel.getUnit4().setText(cell.getUnitNameAtIndex(3));
        tilePanel.getUnit5().setText(cell.getUnitNameAtIndex(4));

        deckPanel.getCircleMiddle().setText(String.valueOf(cell.getCellPosition().getCircle()));
        deckPanel.getBlockMiddle().setText(String.valueOf(cell.getCellPosition().getBlock()));
        deckPanel.getToClockwiseMiddle().setText(String.valueOf(cell.getCellPosition().getClockwise()));
      }
      @Override
      public void mouseReleased(MouseEvent mouseEvent) {  }
      @Override
      public void mouseEntered(MouseEvent mouseEvent) { }
      @Override
      public void mouseExited(MouseEvent mouseEvent) { }
    });

  }


  /**
   * @return JButton the object that has the listeners attached to it.
   */
  @Override
  public JButton getButton() { return button; }


  /**
   * @return The cell which holds the type, units, upgrades and special resources contained in the
   * MapPanelCell
   */
  @Override
  public Cell getCell() { return cell; }

  public void setDeckPanel(DeckPanel newPanel){

  }
}
