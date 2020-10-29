import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloWorld {
  public static void main(String[] args) throws IOException {
    System.out.println("Hello world!!");
    ServerSocket server = new ServerSocket(8580);
    Socket socket = server.accept();
    System.out.println("Client connected");
    InputStream in = socket.getInputStream();
    BufferedInputStream buf = new BufferedInputStream(in);
    while (true) {
      if (buf.available() > 0)
        System.out.print((char) buf.read());
    }
  }
}
