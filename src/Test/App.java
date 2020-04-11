package Test;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {

    public static void main(String[] args) {
        BlockingQueue<String> str = new ArrayBlockingQueue<>(1);
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    str.put(Thread.currentThread() + " " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(str.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
