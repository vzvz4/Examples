package Arlgorithms.myqueue;

public interface MyQueue<E> {
    void push(E value);
    E pop();
    E peekFront();

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

    boolean isFull();
}
