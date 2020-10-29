package Patterns.Structural.Adapter.simpleExemple;

public class USBAdapter extends USB {

  private Connector connector;

  public USBAdapter(Connector connector) {
    this.connector = connector;
  }

  @Override
  public void connect() {
    System.out.println("connection with adapter");
    connector.connect();
  }
}
