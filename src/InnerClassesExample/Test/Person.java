package InnerClassesExample.Test;

import java.util.ArrayList;
import java.util.Scanner;

public class Person {
    private int age;
    private String name;
    ArrayList<Clothes> locker = new ArrayList<>();

    private Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    class Clothes {
        String type;
        String color;

        Clothes() {
        }

        public String getType() {
            return type;
        }

        public String getColor() {
            return color;
        }

        Clothes(String type, String color) {
            this.type = type;
            this.color = color;

        }

    }

    void dressPerson(Clothes []c,int n) {
        System.out.println(name+" надел "+c[n].getType()+" "+c[n].getColor()+" цвета");
    }

    void dressPerson(Clothes c) {
        System.out.println(name+" надел "+c.getType()+" "+c.getColor()+" цвета");
    }

    void addToLocker(String type, String color) {
        locker.add(new Clothes(type,color));
    }

    Clothes[] fillLocker(int clothesVal) {
        Clothes[] clothes;
        clothes = new Clothes[clothesVal];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < clothes.length; i++) {
            clothes[i] = new Clothes(sc.next(), sc.next());
        }
        return clothes;
    }

    public static void main(String[] args) {
        Person.Clothes clothes1 = new Person().new Clothes("Рубашка", "Синяя");
        Person person = new Person(33,"John");
        person.dressPerson(clothes1);
        person.dressPerson(person.fillLocker(3),2);
    }
}
