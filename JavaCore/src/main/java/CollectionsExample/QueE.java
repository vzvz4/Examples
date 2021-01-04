package CollectionsExample;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueE {
    public static void main(String[] args) {
        //Queue - первый зашел первый вышел (FIFO)
        //Метод add == offer; get == poll; element == peek;
        //ArrayBlockingQueue небоходимо обязательно передавать размер в конструктор
        Queue<Integer> que = new ArrayBlockingQueue<>(5);
        //Queue<Integer> queLinked = new LinkedList<>();
        try {
            int a = 0;
            while (true) {
                que.add(a++);
            }
        } catch (IllegalStateException e) {
            que.forEach(System.out::print);
            e.printStackTrace();
        }
    }
}
