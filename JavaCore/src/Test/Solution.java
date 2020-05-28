package Test;

import java.util.*;

public class Solution<E> extends ArrayList<E> {
    private int size;
    private Object[] elementData;

    public void setElementData(Object[] data) {
        elementData = data;
        size = elementData.length;
    }

    class RoundItr implements Iterator<E> {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such

        @Override
        public boolean hasNext() {
            return cursor != size + 1;
        }

        @Override
        public E next() {
            int i = cursor;
            if (i >= size)
                i = 0;
            Object[] elementData = Solution.this.elementData;
            cursor = i + 1;
            return (E) elementData[lastRet = i];
        }

    }

    public Iterator<E> iterator() {
        return new RoundItr();
    }
}
