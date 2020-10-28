package Arlgorithms;

import java.util.Scanner;

public class Filik {

    public static void main(String[] args) {
        int a = 5;
        int temp = telephone(a);
        System.out.println(temp);
    }

    public static int telephone(int i) {
        if (i <= 0) return 0;
        return i + telephone(i - 1);
    }
}
