package Patterns.Behavioral.Memento.Ex1;

public interface Originator {
    String backup();
    void restore(String object);
}
