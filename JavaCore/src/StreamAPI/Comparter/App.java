package StreamAPI.Comparter;

import java.util.*;

public class App {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ba");
        list.add("ab");
        list.add("wwe");
        list.add("hello");
        list.add("goodbye");
        list.add("hi");
        list.add("d");

//         Реализация с анонимным классом

//        list.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if (o1.length()>o2.length())
//                    return 1;
//                else if (o1.length()<o2.length())
//                    return -1;
//                else
//                    return 0;
//            }
//        });

        // сорт в алфавитном порядке
        list.sort(Comparator.comparing(String::intern));

        // сорт по длине слова
        list.sort(Comparator.comparingInt(String::length));

        for (String s : list) {
            System.out.println(s);
        }

        List<Integer> listInt = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 2, 4, 7, 3, 1, 9, 3, 15, 22, 11, 13, 5, 15));
        listInt.sort((a1, a2) -> a2 - a1);
        listInt.forEach(System.out::println);


        //Обратная сортировка по имени
        //До Java 8:

        class User {
            private String name;
            private int age;

            public User(String name, int age) {
                this.age = age;
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public int getAge() {
                return age;
            }
        }

        List<User> users = new ArrayList<>(Arrays.asList(
                new User("Viktor", 54),
                new User("Adolf", 44),
                new User("Billi", 22)));

        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });


        //Сейчас:
        Comparator<User> c = (o1, o2) -> o1.getName().compareTo(o2.getName());
        users.sort(c.reversed());

        //или
        Comparator<User> c2 = Comparator.comparing(User::getName);
        users.sort(c2.reversed());


        //Сортировка с несколькими условиями
        //До Java 8:
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if (o1.getAge() == o2.getAge())
                    return o1.getName().compareTo(o2.getName());
                else return o1.getAge() - o2.getAge();
            }
        });

        //сейчас
        users.sort((o1, o2) -> {
            if (o1.getAge() == o2.getAge())
                return o1.getName().compareTo(o2.getName());
            else return o1.getAge() - o2.getAge();
        });


    }
}
