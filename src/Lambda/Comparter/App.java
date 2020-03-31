package Lambda.Comparter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

        for (String s: list) {
            System.out.println(s);
        }
    }
}
