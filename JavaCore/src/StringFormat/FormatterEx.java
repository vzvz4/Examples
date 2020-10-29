package StringFormat;

import java.util.Formatter;

public class FormatterEx {
  public static void main(String[] args) {
    StringBuilder sbuf = new StringBuilder();
    Formatter fmt = new Formatter(sbuf);
    fmt.format("PI = %f", Math.PI);

    System.out.println(sbuf);
    sbuf.append("sad");
    System.out.println(sbuf);
  }
}
