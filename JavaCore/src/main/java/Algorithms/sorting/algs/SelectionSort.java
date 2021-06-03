package Algorithms.sorting.algs;

public class SelectionSort<T extends Comparable<T>> extends AbsContext<T> {

    public SelectionSort(T[] origin) {
        super(origin);
    }

    @Override
    public T[] sort() {
        int lowBound = 0;
        int upBound = cloned.length;

        while (lowBound < upBound) {
            int i = lowBound + 1;
            T min = cloned[lowBound];
            int ind = -1;
            for (; i < upBound; i++) {
                T curr = cloned[i];
                if (min.compareTo(curr) > 0) {
                    min = curr;
                    ind = i;
                }
            }

            if (ind != -1) {
                System.arraycopy(cloned, lowBound, cloned, lowBound + 1, ind - lowBound);
                cloned[lowBound] = min;
            }

            lowBound++;
        }
        return cloned;
    }

    @Override
    public String getName() {
        return "selection sort";
    }
}
