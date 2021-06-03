package Algorithms.sorting.algs;

public abstract class AbsContext<T extends Comparable<T>> implements SortAlgorithm<T> {
    protected T[] origin;
    protected T[] cloned;

    public AbsContext(T[] origin) {
        this.origin = origin;
        preInitContext();
    }

    protected void preInitContext() {
        cloned = origin.clone();
    }

    @Override
    public T[] getOrigin() {
        return origin;
    }

    @Override
    public T[] getSorted() {
        return cloned;
    }
}
