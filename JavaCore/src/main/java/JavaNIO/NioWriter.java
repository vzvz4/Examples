package JavaNIO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

public class NioWriter {
  public static void main(String[] args) throws IOException {
    File f = new File("C:\\Users\\vzvz4\\Desktop\\PAPKA\\GitHub\\FormatterEx\\JavaCore\\src\\JavaNIO\\1.txt");
    RandomAccessFile rs = new RandomAccessFile(f, "rw");
    byte[] data = new byte[]{55,22,65,47};
//    rs.seek(data.length * 2);
//    rs.write(data);


    FileChannel channel = rs.getChannel();
    String value = "Hello";
    byte[] strBytes = value.getBytes();
    ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
    buffer.put(strBytes);

    buffer.flip();

    channel.write(buffer);

    rs.close();
    channel.close();


    //Lock
    RandomAccessFile stream = new RandomAccessFile(f, "rw");
    FileChannel channel2 = stream.getChannel();

    FileLock lock = null;
    try {
      lock = channel2.tryLock();
    } catch (final OverlappingFileLockException e) {
      stream.close();
      channel2.close();
    }
    stream.writeChars("test lock");
    lock.release();

    stream.close();
    channel.close();
  }
}
