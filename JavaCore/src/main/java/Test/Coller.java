package Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class Coller {
    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();
        queue.add("S");
        queue.add("O");
        System.out.println(queue.poll());
    }
}
