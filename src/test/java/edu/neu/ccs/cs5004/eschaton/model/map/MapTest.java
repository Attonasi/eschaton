package edu.neu.ccs.cs5004.eschaton.model.map;

import edu.neu.ccs.cs5004.eschaton.config.Config;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class MapTest {

  private Config config;
  private Config badConfig;

  private Map original;
  private Map copy;
  private Map same;
  private Map another;
  private Map different;
  private Map nullMap;

  private Point testOrigin;
  private Point differentOrigin;

  @Before
  public void setUp() throws Exception {

    config = new Config();
    testOrigin = config.getOrigin();
    badConfig = new Config(true, 3, 4, testOrigin, 10);

    original = new Map();
    copy = original;
    same = new Map();
    another = new Map();
    different = new Map();
    nullMap = null;

    differentOrigin = new Point(300, 300);
  }

  @Test
  public void getCellAtPosition() {
  }

  @Test
  public void getMapGrid() {
  }

  @Test
  public void getMapSize() {
  }

  @Test
  public void getOrigin() {
  }

  @Test
  public void equals() {
    Assert.assertTrue(original.equals(original));
    Assert.assertTrue(original.equals(copy));
    Assert.assertTrue(original.equals(another) && another.equals(same) &&
    same.equals(original));
    Assert.assertFalse(original.equals(different));
    Assert.assertFalse(original.equals(nullMap));
  }

  @Test
  public void testHashCode() {
    Assert.assertTrue(original.hashCode() == same.hashCode());
  }

  @Test
  public void testToString() {
  }
}