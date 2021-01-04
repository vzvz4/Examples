package Patterns.Structural.Flyweight;

import java.awt.*;

public class Tree {
  private int x, y;
  private TreeType treeType;

  public Tree(int x, int y, TreeType treeType) {
    this.x = x;
    this.y = y;
    this.treeType = treeType;
  }

  public void draw(Graphics graphics) {
    treeType.paint(graphics, this.x, this.y);
  }

  @Override
  public String toString() {
    return "Tree{" +
        "x=" + x +
        ", y=" + y +
        ", treeType=" + treeType +
        '}';
  }
}
