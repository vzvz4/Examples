package CollectionsExample.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyIterator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(1);
        list.add(6);

        //For each появился в Java5
        //в форич нельзя удалять элементы массива
        for (int x: list) {
            System.out.print(x);
        }
        System.out.println("\n");

        //До Java5 использовался Iterator
        //C помощью итератора можно удалять текущий элемент
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
