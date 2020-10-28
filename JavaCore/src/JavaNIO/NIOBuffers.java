package JavaNIO;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOBuffers {
  public static void main(String[] args) throws FileNotFoundException {
    String fileName = "1.txt";
    Path path = Paths.get("./JavaCore",
        "src", "JavaNIO", "folder", fileName);

    RandomAccessFile rf =
        new RandomAccessFile(path.toString(), "rw");
    //SocketChannel - tcp
    //DatagramChannel - udp
    FileChannel channel = rf.getChannel();

    int bufferSize = 5;
    ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
    for (int i = 0; i < bufferSize; i++) {
      buffer.put((byte) i);
    }
    //flip возвращает указатель в начало
    buffer.flip();
    //buffer.put((byte) 4);
    System.out.println(buffer.get());
    System.out.println(buffer.get());
    System.out.println(buffer.get());
    buffer.flip();
    System.out.println(buffer.get());
    System.out.println(buffer.get());
    System.out.println(buffer.get());


  }
}
