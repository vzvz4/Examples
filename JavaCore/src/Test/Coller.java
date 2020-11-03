package Test;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.regex.Pattern;

public class Coller {
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
    }
 }
