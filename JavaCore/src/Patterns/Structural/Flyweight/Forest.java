package Patterns.Structural.Flyweight;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Forest  extends JFrame {

  private final List<Tree> trees;

  public Forest() {
    this.trees = new ArrayList<>();
  }

  public List<Tree> getTrees() {
    return trees;
  }

  public void plantTree(int x, int y, String name, Color color, String  texture) {
    TreeType type = TreeTypeFactory.getTreeType(name, color, texture);
    Tree tree = new Tree(x, y, type);
    trees.add(tree);
  }

  public void plantTree(int x, int y, TreeType treeType) {
    Tree tree = new Tree(x, y, treeType);
    trees.add(tree);
  }

  public void  plantTree(Tree tree) {
    trees.add(tree);
  }

  public void paint(Graphics graphics) {
    for(Tree tree : trees)
      tree.draw(graphics);
  }
}

