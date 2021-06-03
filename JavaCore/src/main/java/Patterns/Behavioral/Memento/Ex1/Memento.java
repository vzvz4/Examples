package Patterns.Behavioral.Memento.Ex1;

public class Memento<T extends Originator> {
    private String state;
    private T object;

    public Memento(T object) {
        this.object = object;
        this.state = object.backup();
    }

    public void restore() {
        object.restore(state);
    }
}
