package EqualsAndHashCode;

import java.util.Objects;

public class Cat implements Comparable<Cat> {
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

    @Override
    public int compareTo(Cat o) {
        return this.name.compareTo(o.name);
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
