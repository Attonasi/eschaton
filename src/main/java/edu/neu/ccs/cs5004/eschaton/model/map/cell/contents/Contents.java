package edu.neu.ccs.cs5004.eschaton.model.map.cell.contents;

public class Contents implements ContentsInteface{

  private Integer wood;
  private Integer food;
  private Integer iron;
  private Integer stone;
  private Integer gold;

  public Contents(Integer wood, Integer food, Integer iron, Integer stone, Integer gold) {
    this.wood = wood;
    this.food = food;
    this.iron = iron;
    this.stone = stone;
    this.gold = gold;
  }

  /**
   * @return Integer the base amount of Wood produced by this cell when collected by the player
   * every rotation.
   */
  @Override
  public Integer getWood() {
    return wood;
  }

  /**
   * @return Integer the base amount of Food produced by this cell when collected by the player
   * every rotation.
   */
  @Override
  public Integer getFood() {
    return food;
  }

  /**
   * @return Integer the base amount of Iron produced by this cell when collected by the player
   * every rotation.
   */
  @Override
  public Integer getIron() {
    return iron;
  }

  /**
   * @return Integer the base amount of Stone produced by this cell when collected by the player
   * every rotation.
   */
  @Override
  public Integer getStone() {
      return stone;
  }

  /**
   * @return Integer the base amount of Gold produced by this cell when collected by the player
   * every rotation.
   */
  @Override
  public Integer getGold() {
    return gold;
  }
}
