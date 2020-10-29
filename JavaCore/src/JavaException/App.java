package JavaException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class App {
    static int [][] ss = new int[2][2];
    private static void method() throws Exception {
        int a = 0;
        int h = 0;
        int b = divide(a);
    }
    FileInputStream s;

    {
        try {
            s = new FileInputStream("w");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int divide(int a) throws DivideByZeroException {
        if (a == 0) {
            throw new DivideByZeroException();
        }
            return 10 / a;
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < ss.length; i++) {
            for (int j = 0; j <ss[i].length ; j++) {
                ss[i][j] = j;
            }
        }
        int [][] s = new int [1][3];
        System.out.println(s.length);
        if (ss[ss.length][1] == 3) {
            method();
        }
    }
}
