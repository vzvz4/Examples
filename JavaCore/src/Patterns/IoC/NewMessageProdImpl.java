package Patterns.IoC;

public class NewMessageProdImpl implements MessageProducer {
  @Override
  public String message() {
    return "Hello World!!";
  }
}
