package Fibonacci;

public class Fib {

    public static void main(String[] args) {
        int k = 8;
        System.out.println("First " + k + " Fibonacci number(s): ");

        for (int i = 0; i < 8; i++) {
            System.out.println(fib(i));
        }
    }

    static int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fib(n - 1) + fib(n - 2);
    }

    static int fib2(int n) {
        if(n < 2) return 1;
        return (fib2(n - 2) + fib2(n - 1));
    }

    static void fib3(int val) {
        int sum;
        int d1 = 1, d2 = 1;
        do {
            System.out.print(d1 + " -> ");
            sum = d1 + d2;
            d1 = d2;
            d2 = sum;
        }
        while (sum <= val);
    }

    static int factorial (int i) {
        if (i == 0)
            return 1;
        return factorial(i - 1) + i;
    }
}
