package MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockEx {
//    Основные отличия между Lock и синхронизированными блоками:

//    -- Синхронизированные блоки не гарантируют, что сохранится порядок обращения потоков
//    к критической секции;

//    -- Нельзя выйти из синхронизированного блока по времени ожидания (timeout);

//    -- Синхронизированные блоки должны полностью содержаться в одном методе.
//    Lock может быть захвачен в одном методе, а освобожден в другом.

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new Thread(new ClassEx(i)).start();
        }
    }

     static class ClassEx implements Runnable {
        private int id;

        public ClassEx(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            final Lock lock = new ReentrantLock();
            try {
                lock.lock();
                Thread.sleep(1000);
                System.out.println("Thread "+id+"started");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
