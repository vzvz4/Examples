package MultiThreading;

public class NewApp {
    private int counter;

    public static void main(String[] args) {
        NewApp app = new NewApp();
        try {
            app.doWork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void increment() {
        synchronized (this) {
            counter++;
        }
    }

    private void doWork() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(counter);
    }

}


