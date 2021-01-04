package Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NewTest {
    public static void main(String[] args) {
        String a = "155";
        String b = "55";
        int [] digitsA = convertToIntArray(a.toCharArray()); // метод с fori ... arr[i] = Character.digit(temp[i], 10);
        int [] digitsB = convertToIntArray(b.toCharArray());

        int [] max = digitsA.length > digitsB.length ? digitsA : digitsB;
        int [] min = digitsA.length > digitsB.length ? digitsB : digitsA;

        int [] temp =  new int[max.length];

        System.arraycopy(min, 0, temp,max.length - min.length, min.length);
        StringBuilder result = new StringBuilder();

        int stage = 0;
        for (int i = max.length - 1; i >= 0; i--) {
            int r  = max[i] + temp[i] + stage;
            if (r >= 10) {
                stage = 1;
                r %= 10;
            }
            else stage = 0;
            result.insert(0, r);
        }
        System.out.println((stage == 0 ? "" : 1) + result.toString());
    }

    private static int[] convertToIntArray(char[] arr) {
        int[] ar = new int[arr.length];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = Character.digit(arr[i], 10);
        }
        return ar;
    }
}
