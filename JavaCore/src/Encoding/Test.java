package Encoding;

import java.beans.Encoder;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {
  public static void main(String[] args) throws IOException {
    System.out.println(decodeText("Jяvя"));
    System.out.println((int) 'T');
    System.out.println(Charset.defaultCharset().displayName());

    System.out.println(convertToBinary("語", "UTF-8"));
    System.out.println("----------------------");

    System.out.println(String.format("%1$" + Byte.SIZE + "s", Integer.toBinaryString(4)).replace(" ", "0"));
  }

  private static String decodeText(String input, String encoding) throws IOException {
    return new BufferedReader(
            new InputStreamReader(
                new ByteArrayInputStream(input.getBytes()),
              Charset.forName(encoding)
            ))
            .readLine();
  }

  private static String decodeText(String input) throws IOException {
    return new BufferedReader(
        new InputStreamReader(
            new ByteArrayInputStream(input.getBytes())
        ))
        .readLine();
  }

  private static String convertToBinary(String input, String encoding)
      throws UnsupportedEncodingException {
    byte[] encoded_input = Charset.forName(encoding)
        .encode(input)
        .array();
    System.out.println(Arrays.toString(encoded_input));
    return IntStream.range(0, encoded_input.length)
        .map(i -> encoded_input[i])
        .mapToObj(e -> Integer.toBinaryString(e ^ 255))
        .map(e -> String.format("%1$" + Byte.SIZE + "s", e).replace(" ", "0"))
        .collect(Collectors.joining(" "));
  }
}
