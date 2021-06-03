package Patterns.Behavioral.TamplateMethod.Ex1;

public class ExtendedAlgorithm extends BaseAlgorithm {
    @Override
    protected boolean step1() {
        return true;
    }

    @Override
    protected void step2() {
        System.out.println("Hello");
    }
}
