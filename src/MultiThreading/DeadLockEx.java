package MultiThreading;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockEx {
    public static void main(String[] args) throws InterruptedException {
        Runner r = new Runner();
        Thread t1 = new Thread(r::firstThread);

        Thread t2 = new Thread(r::secondThread);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        r.finished();
    }

    static class Runner {
        private Account acc1 = new Account();
        private Account acc2 = new Account();

        private Lock lock1 = new ReentrantLock();
        private Lock lock2 = new ReentrantLock();

        private void setLocks(Lock lock1, Lock lock2) {
            boolean firstLockTaken = false;
            boolean secondLockTaken = false;
            while (true) {
                try {
                    firstLockTaken = lock1.tryLock();
                    secondLockTaken = lock2.tryLock();
                } finally {
                    if (firstLockTaken && secondLockTaken)
                        return;
                    if (firstLockTaken)
                        lock1.unlock();
                    if (secondLockTaken)
                        lock2.unlock();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void firstThread() {
            Random random = new Random();
            for (int i = 0; i < 10000; i++) {
                setLocks(lock1,lock2);
//                lock2.lock();
//                //первый поток остановился здесь
//                lock1.lock();
                try {
                    Account.transfer(acc1, acc2, random.nextInt(100));
                } finally {
                    lock1.unlock();
                    lock2.unlock();
                }
            }
        }

        public void secondThread() {
            Random random = new Random();
            for (int i = 0; i < 10000; i++) {
                setLocks(lock2,lock1);
//                lock1.lock();
//                //второй поток остановился здесь
//                lock2.lock();
                try {
                    Account.transfer(acc2, acc1, random.nextInt(100));
                } finally {
                    lock1.unlock();
                    lock2.unlock();
                }
            }
        }

        public void finished() {
            System.out.println(acc1.getBalance());
            System.out.println(acc2.getBalance());
            System.out.println("Total balance: " + (acc1.getBalance() + acc2.getBalance()));
        }

    }

    static class Account {
        private int balance = 10000;

        public void deposit(int amount) {
            balance += amount;
        }

        public void withdraw(int amount) {
            balance -= amount;
        }

        public int getBalance() {
            return balance;
        }

        public static void transfer(Account acc1, Account acc2, int amount) {
            acc1.withdraw(amount);
            acc2.deposit(amount);
        }
    }

}


