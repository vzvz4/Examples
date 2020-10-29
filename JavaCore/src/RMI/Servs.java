package RMI;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.Socket;
import java.net.ServerSocket;

public class Servs {
  public void main (String... args) throws IOException {
    ServerSocket socket = new ServerSocket(8090);
    while (socket.isBound()) {
      Socket sc = socket.accept();
      new Thread(() -> {
        try(MsgHandler handler = new MsgHandler(sc)) {
          handler.listenFileName();
          handler.response();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }).start();
    }

  }

  private static class MsgHandler implements Closeable {
    private final Socket socket;
    private final InputStream in;
    private final OutputStream out;
    private final ByteArrayOutputStream bOut;

    public MsgHandler(Socket socket) throws IOException {
      this.socket = socket;
      in = socket.getInputStream();
      out = socket.getOutputStream();
      bOut = new ByteArrayOutputStream();
      Path p = Paths.get("");
    }

    private void listenFileName() throws IOException {
      byte[] buffer = new byte[8192];
      while(in.available() > 0) {
        int off = in.read(buffer);
        bOut.write(buffer, 0, off);
      }
    }

    public void response() throws IOException {
      String file = new String(bOut.toByteArray(), "UTF-8");
      byte[] data = Files.readAllBytes(Paths.get(file));
      out.write(data);
      out.close();
    }

    public void close() throws IOException {
      socket.close();
      in.close();
      out.close();
      bOut.close();
    }
  }

}
