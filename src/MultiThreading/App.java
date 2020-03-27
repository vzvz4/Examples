package MultiThreading;

public class App {
    static class MyRunnableClass implements Runnable {
        public synchronized void doIt() {
            System.out.println("Do1");
        }
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                    System.out.println("new thread: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyThread extends Thread {
        public synchronized void doIt() {
            System.out.println("Do1");
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                    System.out.println("new thread: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnableClass());
        t1.setPriority(10);
        t1.start();
        Thread t2 = new Thread(new MyRunnableClass());
        t2.setPriority(1);
        t2.start();

        App.MyRunnableClass a = new App.MyRunnableClass();
        new Thread(a::doIt).start();

        //new MyThread().start();
    }
}
