package Patterns.Structural.Adapter.simpleExemple;

public class Client {
  public static void main(String[] args) {
    HDMIConnector hdmi = new HDMIConnector();
    USB adapter = new USBAdapter(hdmi);
    adapter.connect();
  }
}
