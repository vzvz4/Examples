package Patterns.Adapter;

public class App {
    public static void main(String[] args) {
        Adapter.process(new LetterChanger(),"Hello world!");
    }
}
