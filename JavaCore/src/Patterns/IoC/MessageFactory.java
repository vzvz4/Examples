package Patterns.IoC;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class MessageFactory {

  private static MessageRenderer messageRenderer;
  private static MessageProducer messageProducer;

  static {
    Properties properties = new Properties();
    try(InputStream in =
            new FileInputStream("C:\\Users\\vzvz4\\Desktop\\PAPKA\\GitHub\\FormatterEx\\JavaCore\\src\\Patterns\\IoC\\app.properties")) {
      properties.load(in);
      String producer = properties.getProperty("messageProducer");
      String renderer = properties.getProperty("messageRenderer");
      messageProducer = (MessageProducer) Class.forName(producer).newInstance();
      messageRenderer = (MessageRenderer) Class.forName(renderer)
          .getConstructor(MessageProducer.class).newInstance(messageProducer);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static MessageRenderer getMessageRenderer() {
    return messageRenderer;
  }

  public static MessageProducer getMessageProducer() {
    return messageProducer;
  }

}
