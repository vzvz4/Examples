package Patterns.Structural.Flyweight;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TreeTypeFactory {
  private static final Map<String, TreeType> treeTypes;

  static {
    treeTypes = new HashMap<>();
  }

  public static TreeType getTreeType(String name, Color color, String texture) {
    TreeType type = treeTypes.get(name);
    if (type == null)
      type = new TreeType(name, color, texture);
    treeTypes.put(name, type);
    return type;

  }

}
