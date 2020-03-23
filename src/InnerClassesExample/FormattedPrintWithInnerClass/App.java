package InnerClassesExample.FormattedPrintWithInnerClass;

public class App {
    static class Person {
        private String name;
        private int age;
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

    }

    public static void main(String[] args) {
        Human h = new Human("D",33);
        Human h2 = new Human("D",33);
        Human h3 = new Human("D",34);
        Human h4 = h;
        System.out.println(h.equals(h2));
        System.out.println(h.equals(h3));
        System.out.println(h.equals(h4));
        System.out.println(h3.equals(h4));

        Person p = new Person("s",22);
        Human.Students s = h.students;
        System.out.printf("Курс %d%n", s.getCourse());
        Person person = new Person("John", 45);
        System.out.printf("%s напиши этот текст тебе же уже %d лет", person.name, person.age);
    }
}
