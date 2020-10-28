package Patterns.Structural.Decorator;

import java.io.File;
import java.io.IOException;

public class Client {

    public static void main(String[] args) throws IOException {
        File f = new File("./JavaCore/src/Patterns/Structural/Decorator/Example.txt");

        DataSource d = new EncryptionDecorator(new FileDataSource(f));
        DataSource standard = new FileDataSource(f);

        standard.writeData("HelloWorld");
        System.out.println(standard.readData());

        d.writeData("Hello world");
        System.out.println(d.readData());
    }
}
