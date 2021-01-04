package CollectionsExample.MyVersionOfArrayList;

import java.util.Arrays;
import java.util.Iterator;

public class Col<E> implements Iterable<E> {
    private Object[] data;
    private int size;
    private final short DEFAULT_CAPACITY = 10;
    private int initialCapacity;

    public Col() {
        data = new Object[DEFAULT_CAPACITY];
    }

    public Col(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        data = initialCapacity > 0 ? new Object[initialCapacity] :
                new Object[DEFAULT_CAPACITY];
    }

    private boolean isFull() {
        return size == data.length;
    }

    private void grow() {
        Object[] temp = data;
        data = new Object[size + ((initialCapacity != 0) ?
                initialCapacity : DEFAULT_CAPACITY)];
        if (temp.length >= 0) System.arraycopy(temp, 0, data, 0, temp.length);
    }

    public void add(E obj) {
        if (isFull()) {
            grow();
        }
        data[size++] = obj;
    }

    @Override
    public String toString() {
        trimToSize();
        return Arrays.toString(data);
    }

    private void trimToSize() {
        Object[] temp = data;
        data = new Object[size];
        System.arraycopy(temp, 0, data, 0, data.length);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int cursor = 0;

            @Override
            public boolean hasNext() {
                for (Object datum : data) {
                    if (datum == null)
                        return false;
                }
                cursor++;
                return cursor < data.length;
            }

            @Override
            public E next() {
                return (E) data[cursor];
            }
        };
    }
}
