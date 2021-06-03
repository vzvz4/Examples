package Patterns.Behavioral.Memento.Ex1;

import java.util.ArrayList;
import java.util.List;

public class History<T extends Originator> {
    private List<Memento<T>> historyList;
    private int virtualIndex;

    public History() {
        historyList = new ArrayList<>();
        virtualIndex = -1;
    }

    public void push(T element) {
        historyList.add(new Memento<>(element));
        virtualIndex++;
    }

    public void undo() {
        if (virtualIndex >= 0)
        historyList.get(--virtualIndex).restore();
    }

    public void redo() {
        if (virtualIndex < historyList.size())
        historyList.get(++virtualIndex).restore();
    }

}
