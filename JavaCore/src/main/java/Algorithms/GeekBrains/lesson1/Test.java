package Algorithms.GeekBrains.lesson1;

public class Test {

    public static void main(String[] args) {
        String[] array = new String[100];
        String str = "str";
        for (String s : array) {
            if (str.equals(s)) {
                System.out.println("find!");
                break;
            }
        }
    }
}
