package StringsWork;

import java.io.*;
import java.util.Random;

public class BufferedClasses {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Users\\vorobevva\\IdeaProjects\\examples\\src\\Lesson7\\res\\BuffOut3.txt";
        OutputStream out = new FileOutputStream(new File(path),true);
        PrintWriter pr = new PrintWriter(out);
        StringBuilder st = new StringBuilder();

        pr.println(st);
        System.out.println(st);
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            byte[] buffer = new byte[1000];
            st.append(new Integer(random.nextInt(99)));
            pr.println(st);
        }
        pr.close();
    }
}
