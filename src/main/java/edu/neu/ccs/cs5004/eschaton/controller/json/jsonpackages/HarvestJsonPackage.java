package edu.neu.ccs.cs5004.eschaton.controller.json.jsonpackages;

public class HarvestJsonPackage {

  private Integer playerNum;
  private Integer[] harvest;

  public HarvestJsonPackage(Integer playerNum, Integer[] harvest) {
    this.playerNum = playerNum;
    this.harvest = harvest;
  }
}
