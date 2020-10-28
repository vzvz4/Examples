package InputOutputStreams;

import java.io.*;
import java.util.Arrays;


public class App {
    public static void main(String[] args) {
        //byte input stream (ByteArrayOutputStream)
        byte[] arr2 = {0, 127, -1};
        ByteArrayInputStream in2 = new ByteArrayInputStream(arr2);
        int x2;
        while ((x2 = in2.read()) != -1) {
            System.out.print(x2 + " ");
        }

        //byte output stream (ByteArrayOutputStream)
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(10);
        out.write(11);
        byte[] arr = out.toByteArray();
        System.out.println(Arrays.toString(arr));

        //запись в файл (FileOutputStream)
        byte[] outData = "Java\n".getBytes();
        try (FileOutputStream out2 = new FileOutputStream("src/InputOutputStreams/demo.txt", true)) {
            out2.write(outData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //побайтовая запись (FileOutputStream)
        byte[] outData2 = new byte[1024 * 1024];
        Arrays.fill(outData2, (byte) 65);
        try (FileOutputStream out3 = new FileOutputStream("src/InputOutputStreams/demo2.txt")) {
            for (byte b : outData2) {
                out3.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //файловый поток ввода (FileInputStream)
        byte[] buf4 = new byte[3];
        try (FileInputStream in4 = new FileInputStream("src/InputOutputStreams/demo.txt")) {
            int count;
            while ((count = in4.read(buf4)) > 0) {
                for (int i = 0; i < count; i++) {
                    System.out.print((char) buf4[i]);
                }
            }
            System.out.println(Arrays.toString(buf4));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Буферизованный поток ввода/вывода (BufferedInput/OutputStream)
        try (OutputStream out5 = new BufferedOutputStream(new FileOutputStream("src/InputOutputStreams/demo.txt"))) {
            for (int i = 0; i < 10; i++) {
                out5.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (InputStream in5 = new BufferedInputStream(new FileInputStream("src/InputOutputStreams/demo.txt"))) {
            int x;
            while ((x = in5.read()) != -1) {
                System.out.print((char) x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //DataInputStream и DataOutputStream
        try (DataOutputStream out6 = new DataOutputStream(new FileOutputStream("src/InputOutputStreams/demo.txt"))) {
            out6.writeInt(1128);
            out6.writeLong(1111111128L);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (DataInputStream in6 = new DataInputStream(new FileInputStream("src/InputOutputStreams/demo.txt"))) {
            System.out.println(in6.readInt());
            System.out.println(in6.readLong());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //PipedInputStream и PipedOutputStream
        try (PipedInputStream in7 = new PipedInputStream();
             PipedOutputStream out7 = new PipedOutputStream(in7)) {
            for (int i = 0; i < 10; i++) {
                out7.write(i);
            }

            int x;
            while ((x = in7.read()) != -1) {
                System.out.print(x + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //SequenceInputStream
        try (SequenceInputStream seq = new SequenceInputStream(new FileInputStream("src/InputOutputStreams/1.txt"),
                new FileInputStream("src/InputOutputStreams/2.txt"));
             FileOutputStream out8 = new FileOutputStream("src/InputOutputStreams/out.txt")) {
            int x;
            while ((x = seq.read()) != -1) {
                out8.write(x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //BufferedWriter и BufferedReader
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/InputOutputStreams/demo3.txt"))) {
            for (int i = 0; i < 20; i++) {
                writer.write("Java\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(
                "src/InputOutputStreams/demo2.txt"))) {
            String str = "";
            StringBuffer st2 = new StringBuffer();
            while ((str = reader.readLine()) != null) {
                st2.append(str);
            }
            System.out.println(st2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //RandomAccessFile
        try (RandomAccessFile raf = new RandomAccessFile("src/InputOutputStreams/demo3.txt", "r")) {
            raf.seek(2);
            System.out.println((char) raf.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
