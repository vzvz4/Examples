package ComparatorComparable;

import java.util.*;

public class MyComparator implements Comparator<String> {
    //        s1 > s2 => 1;
    //        s1 < s2 => -1;
    //        s1 = s2 => 0;
    //   Подставив нашу реализацию в метод sort у листа мы можем отсортировать список

    public static void main(String[] args) {
        MyComparator m1 = new MyComparator();

        List <String> list = new ArrayList<>();
        list.add("Cooooooooow");
        list.add("wwooww");
        list.add("aa");
        list.add("wwwwwwww");

        list.sort(m1);
        System.out.println(list);

        //реализация через лямбда выражение
        list.sort(Comparator.comparing(String::length));
    }

    @Override
    public int compare(String s1, String s2) {
        if (s1.length() > s2.length()) return 1;
        else if (s1.length() < s2.length()) return -1;
        else return 0;
    }
}
