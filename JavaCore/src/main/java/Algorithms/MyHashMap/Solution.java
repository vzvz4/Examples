package Algorithms.MyHashMap;


import Algorithms.MyHashMap.strategy.HashMapStorageStrategy;
import Algorithms.MyHashMap.strategy.MyOwnHashMapStrategy;
import Algorithms.MyHashMap.strategy.StorageStrategy;

import java.util.Date;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Solution {

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        return strings.stream().map(shortener::getId)
                .collect(Collectors.toSet());
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        return keys.stream().map(shortener::getString)
                .collect(Collectors.toSet());
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());

        Set<String> generated = LongStream.range(0, elementsNumber)
                .mapToObj(x -> Helper.generateRandomString())
                .collect(Collectors.toSet());

        Shortener shortener = new Shortener(strategy);

        Set<Long> ids = measureTime(() -> Solution.getIds(shortener, generated));
        Set<String> strings = measureTime(() -> Solution.getStrings(shortener, ids));

        Helper.printMessage(strings.containsAll(generated)? "Тест пройден." : "Тест не пройден.");
    }

    private static <T> T measureTime(Supplier<T> supplier) {
        long start = new Date().getTime();
        T res = supplier.get();
        long result = new Date().getTime() - start;
        Helper.printMessage(String.valueOf(result));
        return res;
    }

    public static void main(String[] args) {
        HashMapStorageStrategy strategy = new HashMapStorageStrategy();
        testStrategy(strategy, 10000);

        MyOwnHashMapStrategy myMap = new MyOwnHashMapStrategy();
        testStrategy(myMap, 10000);

        System.out.println(myMap);
        System.out.println(myMap.getSize());
    }
}
