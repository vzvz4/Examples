package EqualsMethodAndHash;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Cat implements Comparable, Empty {
    private String name;
    private int age;


    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void voice(String g) {
        System.out.println(g);
    }

    public String toString() {
        return name + " : " + age;
    }

    public int compareTo(Object o) {
        return this.age - ((Cat) o).age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat c = (Cat) o;
        return name != null ? name.equals(c.name) : c.name != null && age == c.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

}
