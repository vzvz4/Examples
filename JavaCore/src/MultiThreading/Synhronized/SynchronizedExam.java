package MultiThreading.Synhronized;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SynchronizedExam {

    public static void main(String[] args) {
        new Worker().main();
    }
}

    class Worker {
        final Object lock1 = new Object();
        final Object lock2 = new Object();
        Random random = new Random();

        private List<Integer> list1 = new ArrayList<>();
        private List<Integer> list2 = new ArrayList<>();

        public void addToList1() {
            synchronized (lock1) {
                for (int i = 0; i < 1000; i++) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list1.add(random.nextInt(100));
                }
            }
        }

        public void addToList2() {
            synchronized (lock2) {
                for (int i = 0; i < 1000; i++) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list2.add(random.nextInt(100));
                }
            }
        }

        public void work() {
            addToList1();
            addToList2();
        }

        public void main() {
           long before = System.currentTimeMillis();

           Thread t1 = new Thread(this::work);
           Thread t2 = new Thread(this::work);

           t1.start();
           t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

           long after = System.currentTimeMillis();
            System.out.println(after-before);
            System.out.println(list1.size()+"List1");
            System.out.println(list2.size()+"list2");
        }
    }

