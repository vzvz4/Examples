package Patterns.Behavioral.Strategy.Ex1;

import java.util.Arrays;

public class Apply {

    static String str = "We Love Java";

    static void process(Processor<String, String> p, String input) {
        System.out.println("Name of processor : " + p.name());
        Object o = p.process(input);
        System.out.println(o.getClass());
        System.out.println("Processing... result -> " + p.process(input));
    }

    public static void main(String[] args) {
        process(x -> Arrays.toString(x.split(" ")), str);
    }
}
