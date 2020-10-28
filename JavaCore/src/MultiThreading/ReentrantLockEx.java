package MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockEx {

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(test.getCounter());
    }

    static class Test implements Runnable{
        private int counter;
        private Lock lock = new ReentrantLock();

        public int getCounter() {
            return counter;
        }

        public void increment() {
            for (int i = 0; i < 1000000; i++) {
                counter++;
            }
            System.out.println("Done");
        }

        @Override
        public void run() {
            //в зависимости от того какой поток первый дойдет до метода lock() тот и выполнит
            //следующую часть кода, а остальные потоки будут ждать вызова unlock();
            lock.lock();
            increment();
            lock.unlock();
        }
    }

}
