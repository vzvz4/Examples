package Patterns.Structural.Adapter.ex2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new AdapterRandomNumber(3));
        while (sc.hasNext())
            System.out.println(sc.next());
    }
}
