package Patterns.IoC;

public class SimpleMessageRendererImpl implements MessageRenderer {
  private MessageProducer messageProducer;

  public SimpleMessageRendererImpl(MessageProducer messageProducer) {
    this.messageProducer = messageProducer;
  }

  @Override
  public void render() {
    System.out.println(messageProducer.message());
  }
}
