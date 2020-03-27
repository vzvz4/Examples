package StringsWork;

import java.io.*;

public class Lesson7_Strings {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\vorobevva\\IdeaProjects\\examples\\src\\Lesson7\\res\\out.txt";
        File file = new File(path);
        //file.createNewFile();
        OutputStream fout = new FileOutputStream(file,true);
//        fout.write(49);
//        fout.close();
        PrintWriter pr = new PrintWriter(fout);
        pr.println("awawdawd");
        pr.close();
        InputStream in = System.in;
        OutputStream out = System.out;
    }
}
