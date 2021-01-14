package Algorithms.stack;

import java.util.Arrays;

public class MyStackImpl<E> implements MyStack<E> {
    private E[] data;
    private int size;

    public MyStackImpl(int maxSize) {
        data = (E[]) new Object[maxSize];
    }

    @java.lang.Override
    public void push(E value) {
        data[size++] = value;
    }

    @java.lang.Override
    public E pop() {
        return data[--size];
    }

    @java.lang.Override
    public E peek() {
        return data[size - 1];
    }

    @java.lang.Override
    public int size() {
        return size;
    }

    @java.lang.Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public String toString() {
        final Object[] tmp = new Object[size];
        System.arraycopy(data, 0, tmp, 0, size);
         return Arrays.toString(tmp);
    }
}
