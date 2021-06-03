package Algorithms.sorting.algs;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class AlgorithmFactory<T extends Comparable<T>> {
    private Map<String, Function<T[], SortAlgorithm<T>>> map;
    {
        map = new HashMap<>();
        map.put("bubble", BubbleSort::new);
        map.put("insertion", InsertionSort::new);
        map.put("selection", SelectionSort::new);
        map.put("merge", MergeSort::new);
    }

    public SortAlgorithm<T> getAlgorithm(String name, T[] arr) {
        Function<T [], SortAlgorithm<T>> func = map.get(name);
        if (func == null) throw new RuntimeException("algo not found");
        return func.apply(arr);
    }

    public Map<String, Function<T[], SortAlgorithm<T>>> getMap() {
        return map;
    }
}