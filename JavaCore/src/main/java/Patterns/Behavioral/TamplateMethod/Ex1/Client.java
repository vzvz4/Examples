package Patterns.Behavioral.TamplateMethod.Ex1;

public class Client {
    public static void main(String[] args) {
        BaseAlgorithm algorithm = new BaseAlgorithm();
        BaseAlgorithm extended = new ExtendedAlgorithm();

        algorithm.templateMethod();
        extended.templateMethod();
    }
}
