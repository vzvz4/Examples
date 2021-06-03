package Algorithms.sorting.algs;

import java.lang.reflect.Array;

public class MergeSort<T extends Comparable<T>> extends AbsContext<T> {

    public MergeSort(T[] origin) {
        super(origin);
    }

    @Override
    protected void preInitContext() {
        // ignore cloning
    }

    @Override
    public T[] sort() {
        T[] sorted = mergeSort(origin, origin.getClass().getComponentType());
        cloned = sorted;
        return sorted;
    }

    @SuppressWarnings("unchecked")
    private T[] mergeSort(T[] arr, Class<?> arrType) {
        if (arr.length == 1)
            return arr;

        int leftSize = arr.length / 2;
        int rightSize = arr.length - leftSize;

        T[] left = (T[]) Array.newInstance(arrType, leftSize);
        T[] right = (T[]) Array.newInstance(arrType, rightSize);

        System.arraycopy(arr, 0, left, 0, leftSize);
        System.arraycopy(arr, leftSize, right, 0, rightSize);

        T[] sortedLeft = mergeSort(left, arrType);
        T[] sortedRight = mergeSort(right, arrType);

        T[] resultArr = (T[]) Array.newInstance(arrType, leftSize + rightSize);

        int pointL = 0;
        int pointR = 0;
        int indResult = 0;

        while (pointL < sortedLeft.length && pointR < sortedRight.length) {
            T currentLeft = sortedLeft[pointL];
            T currentRight = sortedRight[pointR];
            T result = currentLeft;
            int compare = currentLeft.compareTo(currentRight);
            if (compare < 0) {
                result = sortedLeft[pointL];
                pointL++;
            } else if (compare > 0) {
                result = sortedRight[pointR];
                pointR++;
            } else pointL++;
            resultArr[indResult] = result;
            indResult++;
        }
        if (pointL > pointR || pointR < sortedRight.length) {
            System.arraycopy(sortedRight, pointR, resultArr, indResult, sortedRight.length - pointR);
        } else if (pointL < pointR || pointL < sortedLeft.length) {
            System.arraycopy(sortedLeft, pointL, resultArr, indResult, sortedLeft.length - pointL);
        }
        return resultArr;
    }

    @Override
    public String getName() {
        return "merge sort";
    }
}
