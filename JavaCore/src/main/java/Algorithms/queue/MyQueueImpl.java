package Algorithms.queue;

import java.util.Arrays;

public class MyQueueImpl<E> implements MyQueue<E> {
    protected int size;
    protected E[] data;

    private int head;
    private int tail;

    private static final int DEFAULT_TAIL = -1;
    private static final int DEFAULT_HEAD = 0;

    @SuppressWarnings("uncheked")
    public MyQueueImpl(int size) {
        data = (E[]) new Object[size];
    }

    @Override //O(1)
    public void insert(E value) {
        if (tail == data.length - 1) {
            tail = DEFAULT_TAIL;
        }
        data[++tail] = value;
        size++;
    }

    @Override
    public E remove() {
        if (head == data.length) {
            head = DEFAULT_HEAD;
        }
        E obj = data[head++];
        size--;
        return obj;
    }

    @Override
    public E peekFirst() {
        return data[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public String toString() {
        final Object[] tmp = new Object[tail - head];
        System.arraycopy(data, head, tmp, 0,  tail - head);
        return Arrays.toString(tmp);
    }
}
