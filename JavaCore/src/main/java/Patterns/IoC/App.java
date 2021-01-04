package Patterns.IoC;

public class App {
  public static void main(String[] args) {
    MessageRenderer messageRenderer = MessageFactory.getMessageRenderer();
    messageRenderer.render();
  }
}
