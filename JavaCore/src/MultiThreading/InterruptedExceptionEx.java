package MultiThreading;

import java.util.Random;

public class InterruptedExceptionEx {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            Random random = new Random();
            for (int i = 0; i < 1_000_000_000; i++) {
//                if (Thread.currentThread().isInterrupted())
//                    break;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("Interrupted");
                    break;
                }
                Math.sin(random.nextDouble());
            }
        });
        System.out.println("Starting thread");
        thread.start();
        thread.interrupt();
        thread.join();
        System.out.println("End of thread");

    }
}
