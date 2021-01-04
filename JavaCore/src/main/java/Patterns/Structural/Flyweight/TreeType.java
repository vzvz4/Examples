package Patterns.Structural.Flyweight;

import java.awt.*;

//flyweight class (Tree type)
public class TreeType extends Canvas {
  private final String name;
  private final Color color;
  private final String texture;

  public TreeType(String name, Color color, String texture) {
    this.name = name;
    this.color = color;
    this.texture = texture;
  }

  public void paint(Graphics g, int x, int y) {
    g.setColor(Color.BLACK);
    g.fillRect(x - 1, y, 3, 5);
    g.setColor(color);
    g.fillOval(x - 5, y - 10, 10, 10);
  }

  @Override
  public String toString() {
    return "TreeType{" +
        "name='" + name + '\'' +
        ", color='" + color + '\'' +
        ", texture='" + texture + '\'' +
        '}';
  }
}
