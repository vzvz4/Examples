package Patterns.Creational.Singleton;

public class App {
    public static void main(String[] args) {
        ConnectionManager.getConnection().connect();
        ConnectionManager.getConnection().connect();
        ConnectionManager.getConnection().connect();
    }
}
