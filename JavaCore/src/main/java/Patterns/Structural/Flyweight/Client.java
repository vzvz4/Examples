package Patterns.Structural.Flyweight;

import javax.swing.*;
import java.awt.*;

public class Client {
  static int CANVAS_SIZE = 500;
  static int TREES_TO_DRAW = 10;
  static int TREE_TYPES = 2;

  public static void main(String[] args) {
    Forest forest = new Forest();
      for (int i = 0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++) {
        forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
            "Summer Oak", Color.GREEN, "100mb Oak texture stub");
        forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
            "Autumn Oak", Color.ORANGE, "150mb Autumn Oak texture stub");
      }
      forest.setSize(CANVAS_SIZE, CANVAS_SIZE);
      forest.setVisible(true);
      forest.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      forest.getTrees().forEach(System.out::println);
  }

  private static int random(int min, int max) {
    return min + (int) (Math.random() * ((max - min) + 1));
  }

}
