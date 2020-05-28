package Patterns.Strategy;

public class Apply {

    static String str = "We Love Java";

    static void process(Processor p, Object input) {
        System.out.println("Name of processor : " + p.name());
        System.out.println("Processing... result -> "+p.process(input));
    }

    public static void main(String[] args) {
        process(new Splitter(), str);
    }
}
