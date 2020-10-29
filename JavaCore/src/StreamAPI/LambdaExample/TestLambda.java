package StreamAPI.LambdaExample;

public class TestLambda {
    public static void method(Executable e) {
        int a = e.execute(5,7);
        System.out.println(a);
    }

    public static void main(String[] args) {

    }

}
