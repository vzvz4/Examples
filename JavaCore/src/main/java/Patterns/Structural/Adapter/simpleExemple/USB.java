package Patterns.Structural.Adapter.simpleExemple;

public class USB implements Connector {

  @Override
  public void connect() {
    System.out.println("Connection with USB-2.0");
  }
}
