package CollectionsExample;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapE {

    public static void main(String[] args) {
        // Map<'KEY','VAL'>...
        // get('KEY');

        // мап содержит пары ключ значение
        Map<Integer, String> hashMap = new HashMap<>(); //Содержит уникальные ключи, внутри не гарантируется порядок, но работает быстрее
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>(); //сохраняется порядок добавления
        Map<Integer, String> treeMap = new TreeMap<>(); //Поддерживается сортировка, пары ключ значение сортируются по ключу (естественный порядок)

        testMap(treeMap);
    }

    public static void testMap(Map<Integer, String> map) {
        map.put(39, "Bob");
        map.put(88, "Alex");
        map.put(101, "Nick");
        map.put(1, "Jack");
        map.put(1500, "Pitt");
        map.put(14, "Bob");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
