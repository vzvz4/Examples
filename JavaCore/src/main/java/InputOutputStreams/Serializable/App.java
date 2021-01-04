package InputOutputStreams.Serializable;

import java.io.*;
import java.util.Arrays;

public class App {
    private static class Cat implements Serializable {
        private String name;
        private transient int id;

        public Cat(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public void startMsg() {
            System.out.println(name+" HELLO");
        }

        @Override
        public String toString() {
            return "Кот " + name +" id " + id;
        }
    }

    public static void main(String[] args) {
        byte[] byteCat = null;
        try (ByteArrayOutputStream barrOut = new ByteArrayOutputStream();
             ObjectOutputStream objOut = new ObjectOutputStream(barrOut)) {
            Cat catOut = new Cat("Барсик",5);
            objOut.writeObject(catOut);
            byteCat = barrOut.toByteArray();
            System.out.println("Кот до сериализации: " + catOut);
            System.out.println("Вот так он выглядит в байтовом представлении: " + Arrays.toString(byteCat));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ByteArrayInputStream barrIn = new ByteArrayInputStream(byteCat);
             ObjectInputStream objIn = new ObjectInputStream(barrIn)) {
            Cat catIn = (Cat) objIn.readObject();
            System.out.println("А вот такого кота мы восстановили из набора байтов: " + catIn);
            System.out.println(catIn.name);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
