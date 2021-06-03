package Algorithms.sorting.algs;

public class InsertionSort<T extends Comparable<T>> extends AbsContext<T> {

    public InsertionSort(T[] origin) {
        super(origin);
    }

    public T[] sort() {
        for (int j = 0; j < cloned.length; j++) {
            int i = j;
            while (i > 0 && cloned[i].compareTo(cloned[i - 1]) < 0) {
                T tmp = cloned[i - 1];
                cloned[i - 1] = cloned[i];
                cloned[i] = tmp;
                i--;
            }
        }
        return cloned;
    }

    @Override
    public String getName() {
        return "insertion sort";
    }
}
