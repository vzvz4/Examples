package MultiThreading;

import java.io.DataOutputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueEx {

    private BlockingQueue<String> drop;
    private final String DONE = "done";
    private final String[] messages = {
            "Мама мыла раму",
            "Папа мыл раму",
            "Дети едят кашу",
            "А что ест папа?"
    };

    public ArrayBlockingQueueEx() {
        drop = new ArrayBlockingQueue<>(1, true);
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }

    public static void main(String[] args) {
        ArrayBlockingQueueEx ar = new ArrayBlockingQueueEx();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            int count = 0;
            try {
                for (String message : messages) {
                    drop.put(message);
                    if (++count < 3)
                        Thread.sleep(2000);
                }
                drop.offer(DONE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            String msg = null;
            try {
                while (!(msg = drop.take()).equals(DONE))
                    System.out.println(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
