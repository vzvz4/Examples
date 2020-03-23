package MultiThreading;

import java.util.Arrays;

public class ArrayCopy {
    public static void main(String[] args) {
        int[] a = {1,1,1,1};
        int[] b = {0,0};
        System.arraycopy(b,0,a,2,2);
        System.out.println(Arrays.toString(a));
    }
}
