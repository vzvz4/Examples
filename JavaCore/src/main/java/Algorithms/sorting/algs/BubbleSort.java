package Algorithms.sorting.algs;

public class BubbleSort<T extends Comparable<T>> extends AbsContext<T> {

    public BubbleSort(T[] origin) {
        super(origin);
    }

    @Override
    public T[] sort() {
        for (int j = 0; j < cloned.length; j++) {
            for (int i = 0; i < cloned.length - 1; i++) {
                T current = cloned[i];
                T next = cloned[i + 1];
                if (current.compareTo(next) > 0) {
                    cloned[i] = next;
                    cloned[i + 1] = current;
                }
            }
        }
        return cloned;
    }

    @Override
    public String getName() {
        return "bubble sort";
    }

}
