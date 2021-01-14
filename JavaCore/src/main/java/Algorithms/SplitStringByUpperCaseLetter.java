package Algorithms;

import java.util.Arrays;

public class SplitStringByUpperCaseLetter {
  public static void main(String[] args) {
    String str = "javaJava";
    String result = Arrays.stream(str.split("(?=\\p{Upper})"))
        .reduce("", (x,y) -> x + " " + y);
    System.out.println(result);
  }
}
