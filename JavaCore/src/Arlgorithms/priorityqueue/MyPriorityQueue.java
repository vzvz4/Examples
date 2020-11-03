package Arlgorithms.priorityqueue;

import Arlgorithms.myqueue.MyQueueImpl;

public class MyPriorityQueue<E extends Object & Comparable<? super E>> extends MyQueueImpl<E> {
    public MyPriorityQueue(int size) {
        super(size);
    }

    @Override // O(n)
    public void insert(E value) {
        int index;
        for(index = size() - 1; index >= 0; index--) {
            if (value.compareTo(data[index]) > 0) {
                data[index + 1] = data[index];
            } else break;
        }
        data[index + 1] = value;
        size++;
    }

    @Override
    public E remove() {
        return isEmpty() ? null : data[--size];
    }

    @Override
    public E peekFirst() {
        return data[size - 1];
    }
}
