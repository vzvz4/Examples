package CollectionsExample;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetE {
    public static void main(String[] args) {
        //сет не может содержать дубликатов
        Set<String> hashSet = new HashSet<>(); //порядок не гарантирован
        Set<String> linkedHashSet = new LinkedHashSet<>(); //элементы добавляются по порядку
        Set<String> treeSet = new TreeSet<>(); //Поддерживается сортировка, сортировка элементов по порядку

        testSet(treeSet);

        hashSet.add("Валера");
        hashSet.add("Viktor");
        hashSet.add("Jhon");
        hashSet.add("Donald");
        hashSet.add("Pitt");

        System.out.println(hashSet.contains("Валера"));


        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            set1.add(i);
            set2.add(i+2);
        }

        //union - объединение множеств
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("union: "+union);

        //intersection - пересечение множетсв
        Set<Integer> intersect = new HashSet<>(set1);
        intersect.retainAll(set2);
        System.out.println("intersection: "+intersect);

        //difference - разность множетсв
        Set<Integer> diff = new HashSet<>(set1);
        Set<Integer> diff2 = new HashSet<>(set2);
        diff.removeAll(set2);
        diff2.removeAll(set1);
        System.out.println("difference1: "+diff);
        System.out.println("difference2: "+diff2);
    }

    public static void testSet(Set<String> set) {
        set.add("Валера");
        set.add("Viktor");
        set.add("Jhon");
        set.add("Donald");
        set.add("Pitt");
        for (String s: set) {
            System.out.println(s);
        }
    }
}
