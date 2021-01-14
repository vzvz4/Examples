package Algorithms.queue;

public class Client {
    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueueImpl<>(10);
        queue.insert("sad");
        System.out.println(queue);
    }
}
