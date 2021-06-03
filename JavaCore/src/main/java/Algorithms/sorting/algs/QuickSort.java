package Algorithms.sorting.algs;

public class QuickSort<T extends Comparable <T>> extends AbsContext<T> {

    public QuickSort(T[] origin) {
        super(origin);
    }

    @Override
    public T[] sort() {
        return cloned;
    }

    @Override
    public String getName() {
        return "quick sort";
    }
}
