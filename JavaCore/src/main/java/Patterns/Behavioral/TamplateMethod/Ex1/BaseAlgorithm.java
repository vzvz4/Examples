package Patterns.Behavioral.TamplateMethod.Ex1;

public class BaseAlgorithm{

    public void templateMethod(){
            if (step1()) {
                step2();
            } else step3();
        }

    protected void step3() {
        System.out.println("A");
    }

    protected void step2() {
        System.out.println("B");
    }

    protected boolean step1() {
        return false;
    }
}