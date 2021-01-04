package MultiThreading;

import java.util.Random;
import java.util.concurrent.*;

public class PatternProducer_Consumer {
    static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        Thread t1 = new Thread(PatternProducer_Consumer::produce);
        Thread t2 = new Thread(PatternProducer_Consumer::consumer);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void produce() {

        Random random = new Random();
        while (true) {
            try {
                queue.put(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void consumer() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(100);

                if (random.nextInt(10) == 5) {
                    System.out.println("Taken: "+queue.take());
                    System.out.println("Size: "+queue.size());
                }
                    System.out.println("____");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
