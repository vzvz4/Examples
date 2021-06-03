package Patterns.Behavioral.Strategy.Ex2;

public class DivisionStrategy implements Strategy {
    @Override
    public void execute(int a, int b) {
        System.out.println(a / (double) b);
    }
}
