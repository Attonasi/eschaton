package edu.neu.ccs.cs5004.eschaton.model.map.cell.cellposition;

import java.util.Objects;

public class CellPosition implements PositionInterface {

  private Integer block;
  private Integer circle;
  private Integer clockwise;

  public CellPosition(Integer circle, Integer block, Integer clockwise) {
    this.circle = circle;
    this.block = block;
    this.clockwise = clockwise;
  }

  public Integer getCircle() {
    return circle;
  }

  public Integer getBlock() {
    return block;
  }

  public Integer getClockwise() {
    return clockwise;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CellPosition that = (CellPosition) o;
    return Objects.equals(block, that.block) &&
        Objects.equals(circle, that.circle) &&
        Objects.equals(clockwise, that.clockwise);
  }

  @Override
  public int hashCode() {
    return Objects.hash(block, circle, clockwise);
  }

  @Override
  public String toString() {
    return "CellPosition{" +
        "block=" + block +
        ", circle=" + circle +
        ", clockwise=" + clockwise +
        '}';
  }
}
