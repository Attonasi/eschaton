package edu.neu.ccs.cs5004.eschaton.model.map.cell.contents;

public abstract class Contents implements ContentsInteface{

  private String contents;

  public Contents(String contents) {
    this.contents = contents;
  }

  public String getContents() {
    return contents;
  }
}
