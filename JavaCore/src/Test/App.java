package Test;


import java.io.File;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {
    static String toCamelCase2(String s) {
        Matcher m = Pattern.compile("[_|-](\\w)").matcher(s);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, m.group(1).toUpperCase());
        }
        return m.appendTail(sb).toString();
    }

    public static String whoLikesIt(String... names) {
        switch (names.length) {
            case 0:
                return "no one likes this";
            case 1:
                return String.format("%s likes this", names[0]);
            case 2:
                return String.format("%s, %s likes this", names[0], names[1]);
            case 3:
                return String.format("%s, %s and %s likes this", names[0], names[1], names[2]);
            default:
                return String.format("%s, %s and other 2 likes this", names[0], names[1]);
        }
    }

    //    [1,3,5,6]
    static String toCamelCase(String s) {
        String[] words = s.split("(_+|\\W+)");
        StringBuilder sb = new StringBuilder(words[0]);
        for (int i = 1; i < words.length; i++) {
            char temp;
            if (!words[i].isEmpty() && words[i].charAt(0) > 'Z') {
                temp = (char) (words[i].charAt(0) - ('a' - 65));
                words[i] = temp + words[i].substring(1);
            }
            sb.append(words[i]);
        }
        return sb.toString();
    }

    public static long digPow(int n, int p) {
        int count = Integer.toString(n).length() + p - 1;
        if (n == 0)
            return 0;
        long result = (long) Math.pow(n % 10, count) + digPow(n / 10, p);
        return result >= n && result % n == 0 ? result / n : result;
    }


    interface Calculate<T> {
        Calculate<T> method(Private<? super T> p);
    }

    interface Private<T> {
        T hello();
    }

    static class Cl1 extends Cl3 {
        private int a;

        public Cl1(int a) {
            this.a = a;
        }
    }

    static class Cl2 extends Cl1 {

        public Cl2(int a) {
            super(a);
        }
    }

    static class Cl3 {

        public Cl3() {

        }
    }


    static class Imp1 implements Calculate<Cl1> {
        Private<Cl1> p;

        public Imp1(Private<Cl1> p) {
            this.p = p;
        }

        @Override
        public Calculate<Cl1> method(Private<? super Cl1> pe) {
            System.out.println(pe.hello());
            return new Imp1(p);
        }
    }

    static class Imp2 implements Private<Cl3> {
        @Override
        public Cl3 hello() {
            return new Cl3();
        }
    }

    static class Person {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    static <T extends Person> T method(T p, Personalize<T> per) {
        return per.refactor(p);
    }

    static <T extends Person> T oboled(T p, int age, String name) {
        p.setAge(age);
        p.setName(name);
        return p;
    }

    @FunctionalInterface
    private interface Personalize<T extends Person> {
        T refactor(T person);
    }

    static class A {
        static int s = 1;
        public void meth() {
            class Imba {
                private int id;
                private String og;

                public Imba(int id, String og) {
                    this.id = id;
                    this.og = og;
                }

                Imba getImba() {
                    return new Imba(id + 1, og + " Imba");
                }
            }

        }

        static {
            System.out.println(s);
        }

        {
            System.out.println(new Random().nextInt(3));
        }

        A() {
            System.out.println(3);
        }
    }

    static class B extends A {

        public void meth() {
            A.s = 2;
        }

        static {
            System.out.println(11);
        }

        {
            System.out.println(22);
        }

        B() {
            System.out.println(33);
        }
    }


    static class Emp implements Comparable<Emp> {
        @Override
        public String toString() {
            return "Emp{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        private int id;
        private String name;

        public Emp(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int compareTo(Emp o) {
            return Integer.compare(id, o.id);
        }

    }

    class Android {
        int age;
    }

    static class TestClass {
        int age = 15;
        Personalize<?> personalize = (p) -> oboled(p, 15, "ss");

        void methods(final int age) {
            Personalize<?> personalize2 = (Personalize<Person>) person -> {
                new App().new Android().age = 44;
                person.setName("Oleg");
                person.setAge(new App().new Android().age);
                return person;
            };
        }

    }
    static class AA {
        static int id;
        static{
            System.out.println("st");
        }
    }

    static class BB extends AA {
        static {
            System.out.println("sb");
        }
    }


    @FunctionalInterface
    interface Filter<T> extends Predicate<T> {
    }

    static IntStream filter(Integer [] obj, Filter<Integer> filter) {
        return Arrays.stream(obj).filter(filter).mapToInt(x -> x);
    }


    static <T> T[] filter2(T[] array, Predicate<T> predicate) {
        int offset = 0;
        for(int i = 0; i< array.length; i++){
            if(!predicate.test(array[i])){
                offset++;
            } else{
                array[i - offset] = array[i];
            }
        }
        return Arrays.copyOf(array, array.length - offset);
    }

    static <T extends Number> T[] fill(T[] array, Function<Integer, ? extends T> function) {
        for (int i = 0; i < array.length; i++) {
            array[i] = function.apply(i);
        }
        return array;
    }

    public static void main(String[] args) {
        ArrayList<String>[] res = new ArrayList[] {new ArrayList<String>(), new ArrayList<>()};
        String[] ress = {"JAva", "Cpp"};
        ArrayList<String> arr = new ArrayList<>();
        arr.add("java");
        arr.add("cpp");
        int length = arr.stream().mapToInt(String::length).max().getAsInt();
        System.out.println(length);
    }
    static class StringDeny {

    }
}
