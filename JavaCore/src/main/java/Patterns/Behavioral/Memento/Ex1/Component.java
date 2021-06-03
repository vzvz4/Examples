package Patterns.Behavioral.Memento.Ex1;

import java.io.Serializable;

public class Component implements Serializable {
    private int val;

    public Component(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Component{" +
                "val=" + val +
                '}';
    }
}
