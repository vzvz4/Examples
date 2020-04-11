package JUnitEx;

public class SomeClass {

    public static void main(String[] args) {
        SomeClass sm = new SomeClass();
        sm.doMath(3, 5);
    }

    public int doMath(int a, int b) {
        if (a == b)
            throw new IllegalArgumentException("числа равны");
        return Integer.sum(a, b);
    }
}
