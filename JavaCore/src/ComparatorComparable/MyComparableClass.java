package ComparatorComparable;

import java.util.*;

public class MyComparableClass {

    static class Cat implements Comparable<Cat>{
        //интерфейс компарабл нужен для коллекции TreeSet, TreeMap

        private String name;

        public Cat(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public int compareTo(Cat o) {
            return o.name.compareTo(this.name);
        }
    }

    public static void main(String[] args) {
        Cat cat = new Cat("BARSIK");
        Cat cat2 = new Cat("BARSIK");
        Set<Cat> set = new TreeSet<>();
        set.add(cat);
        set.add(cat2);
        System.out.println(set);
    }

}
