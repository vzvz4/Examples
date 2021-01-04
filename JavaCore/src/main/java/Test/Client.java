package Test;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        int chislo = 2;
        int a = fib(chislo);
        System.out.println(a);
    }

    public static int fib(int fibonacci) {
        if (fibonacci == 4) return fibonacci;
        return fib(fibonacci + 2);
    }
}
