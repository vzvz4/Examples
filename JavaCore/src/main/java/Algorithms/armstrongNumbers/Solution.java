package Algorithms.armstrongNumbers;

import java.util.Arrays;

/* 
Алгоритмы-числа
*/
public class Solution {

    public static long[] getNumbers(long N) {
        if (N > 0) {
            final Runner runner = new Runner();
            int level = String.valueOf(N).length() - 1;
            return runner.exec(level);
        } else return new long[0];
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
