package Test;

public class Coller {
    public static void main(String[] args) {
        int a = 5;
        System.out.println(rec(5));
    }

    public static int rec(int r) {
        if (r == 0) return 0;
        return r + rec(r - 1);
    }
 }
