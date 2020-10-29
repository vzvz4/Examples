package Patterns.Structural.Adapter.ex1;

public class Adapter {

    static String str = "We Love Java";

    static void process(Processor p, Object input) {
        System.out.println("Name of processor : " + p.name());
        System.out.println("Processing... result -> "+p.process(input));
    }

}
