package Patterns.Structural.Adapter.simpleExemple;

public class HDMIConnector implements Connector {
  @Override
  public void connect() {
    System.out.println("connection with HDMI-1.0");
  }
}
