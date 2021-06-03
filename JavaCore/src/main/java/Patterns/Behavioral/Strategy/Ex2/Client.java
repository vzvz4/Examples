package Patterns.Behavioral.Strategy.Ex2;

public class Client {
    public static void main(String[] args) {
        Context context = new Context(new SumStrategy());
        context.doMath(3, 4);
        context.setStrategy(new DivisionStrategy());
        context.doMath(3, 4);
    }
}
