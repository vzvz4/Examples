package Test;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.regex.Pattern;

public class Coller {
<<<<<<< HEAD
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
=======
    public static void main(String[] args) throws IOException {
        File f = new File("tmp");
        FileWriter writer = new FileWriter(f);
        Date d = new Date();
        System.out.println(d.getTime());
        writer.write(String.valueOf(d.getTime()));
        writer.close();
        ArrayDeque

        BufferedReader reader = new BufferedReader(new FileReader("tmp"));
        System.out.println(reader.readLine());
>>>>>>> feature
    }
 }
