package Algorithms.queue;

public interface MyQueue<E> {
    void insert(E value);

    E remove();

    E peekFirst();

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

    boolean isFull();
}
