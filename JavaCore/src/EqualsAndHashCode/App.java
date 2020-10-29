package EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;


public class App {

    //1. для одного и того-же объекта, хеш-код всегда будет одинаковым;
    //2. если объекты одинаковые, то и хеш-коды одинаковые (но не наоборот);
    //3. если хеш-коды равны, то входные объекты не всегда равны (коллизия);
    //4. если хеш-коды разные, то и объекты гарантированно разные;

    public static void main(String[] args) {
        Cat cat = new Cat("s",1);
        Cat cat1 = new Cat("s", 1);
        Cat catA = new Cat("b", 2);
        Cat cat2 = cat;
        Cat cat3 = new Cat("s",3);
        Cat cat4 = new Cat("a",4);
        Cat cat5 = new Cat("h",5);
        Cat cat6 = new Cat("b",1);


//        System.out.println(cat.equals(cat1)+" "+cat1.equals(cat2)+" "+cat2.equals(dog));

        System.out.println(cat.hashCode());
        System.out.println(cat1.hashCode());
        System.out.println(cat2.hashCode());

        System.out.println(catA.hashCode());

        ArrayList <Cat> cats = new ArrayList<>();
        cats.add(cat);
        cats.add(cat2);

        System.out.println(cats.size());

        System.out.println(cats.contains(cat));

        System.out.println(cats.indexOf(cat));

        //cats.remove(cat);

        System.out.println(cats.size());

        for (Cat c: cats) {
            System.out.println(c);
        }
        System.out.println("____HashSet__________");
        HashSet<Cat> catsSet = new HashSet<>();
        catsSet.add(cat);
        catsSet.add(cat1);
        catsSet.add(cat2);
        catsSet.add(cat3);
        catsSet.add(cat4);
        catsSet.add(cat5);
        catsSet.add(cat6);
        catsSet.add(catA);
        for (Cat c: catsSet) {
            System.out.println(c);
            //System.out.println(c.hashCode());
        }

        System.out.println("_____catsTree_________");
        TreeSet<Cat> catsTree = new TreeSet<>();
        catsTree.add(cat);
        catsTree.add(cat1);
        catsTree.add(cat2);
        catsTree.add(cat3);
        catsTree.add(cat4);
        catsTree.add(cat5);
        catsTree.add(cat6);
        catsTree.add(catA);
        for (Cat c: catsTree) {
            System.out.println(c);
        }
    }
}
