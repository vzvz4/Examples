package Regex;

import java.util.Arrays;

public class Split {
    public static void main(String[] args) {
        String a = "split this";
        String [] b = a.split(" ");

        System.out.println(a.replaceAll("\\S","w"));

        //Split by UpperCase character
        String str = "javaJava";
        String result = Arrays.stream(str.split("(?=\\p{Upper})"))
            .reduce("", (x,y) -> x + " " + y);
        System.out.println(result);
    }
}
