package Test;

public class Coller {
<<<<<<< HEAD
    private String name;

    public Coller(String name) {
        this.name = name;
=======
    public static void main(String[] args) {
        int a = 5;
        System.out.println(rec(5));
    }

    public static int rec(int r) {
        if (r == 0) return 0;
        return r + rec(r - 1);
>>>>>>> f038b07a2d68d466d1b619fc9c7cac84c6b6ba43
    }
 }
