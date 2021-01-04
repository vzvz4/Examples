package JavaNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.util.Iterator;

public class NIOServer implements Runnable {
  private ServerSocketChannel server;
  private Selector selector;
  private static int user_counter;

  public NIOServer() throws IOException {
    server = ServerSocketChannel.open();
    server.socket().bind(new InetSocketAddress(8190));
    server.configureBlocking(false);
    selector = Selector.open();
    server.register(selector, SelectionKey.OP_ACCEPT);
  }

  @Override
  public void run() {
    try {
      System.out.println("-:server started");
      while (server.isOpen()) {
        int event = selector.select();
        System.out.println("-:event selected: " + event);
        Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
        while (iterator.hasNext()) {
          SelectionKey selectionKey = iterator.next();
          iterator.remove();
          if (selectionKey.isAcceptable()) {
            System.out.println("-:client accepted: " + selectionKey.channel().provider());
            SocketChannel channel = ((ServerSocketChannel) selectionKey.channel()).accept();
            channel.configureBlocking(false);
            user_counter++;
            channel.register(selector, SelectionKey.OP_READ, user_counter);
            System.out.println("-:addr: " + channel.getRemoteAddress() + ":");
            channel.write(ByteBuffer.wrap(":Hello!\n".getBytes()));
          }
          if (selectionKey.isReadable()) {
            System.out.println(":--Read key--:");
            ByteBuffer buffer = ByteBuffer.allocate(80);
            int buffered = ((SocketChannel) selectionKey.channel()).read(buffer);
            if (buffered == -1)
              (selectionKey.channel()).close();
            System.out.println("-:buffered data: " + buffered);
            buffer.flip();
            System.out.println("-:start_data:");
            while (buffer.hasRemaining()) {
              System.out.print((char) buffer.get());
            }
            buffer.flip();
            for (SelectionKey selectionKey1 : selector.keys()) {
              if (selectionKey1.channel() instanceof SocketChannel && selectionKey1.isReadable()) {
                ((SocketChannel) selectionKey1.channel()).write(buffer);
              }
            }
            System.out.println();
            System.out.println("-:data_end");
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws IOException {
    new Thread(new NIOServer()).start();
  }
}
