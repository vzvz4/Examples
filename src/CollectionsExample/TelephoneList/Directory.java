package CollectionsExample.TelephoneList;

import java.util.Set;
import java.util.TreeSet;

public class Directory {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("Aльфa");
        set.add("Бета");
        set.add("Aльфa");
        set.add("Этa");
        set.add("Гaммa");
        set.add("Эпсилон");
        set.add("Омега");
        set.add("Гaммa");
        System.out.println(set);
        Set<Person> personSet = new TreeSet<Person>();
        System.out.println("---------");
        Person oleg   = new Person("Oleg","Petrov", 27);
        Person alexey = new Person("Alexey", "Petrov", 29);
        personSet.add(oleg);
        personSet.add(alexey);

        for (Person person : personSet) {
            System.out.println(person);
        }
    }
}
