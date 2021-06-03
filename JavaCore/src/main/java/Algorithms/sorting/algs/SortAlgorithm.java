package Algorithms.sorting.algs;

public interface SortAlgorithm<T extends Comparable<? super T>> {
    T[] sort();
    String getName();
    T[] getOrigin();
    T[] getSorted();
}
