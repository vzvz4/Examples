package MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

            for (int i = 0; i < 5; i++) {
                executorService.submit(new Work(i));
        }

        executorService.shutdown();
        System.out.println("All tasks submitted");

        executorService.awaitTermination(1,TimeUnit.DAYS);
        System.out.println("All task done");

        System.out.println(Work.count);
    }
}

class Work implements Runnable {

    static volatile int count;
    private int id;

    public Work(int id) {
        this.id = id;
    }

    synchronized void eval() {
            count++;
    }

    @Override
    public void run() {
            for (int i = 0; i < 17; i++) {
                eval();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("work " + id + " completed");
    }
}
