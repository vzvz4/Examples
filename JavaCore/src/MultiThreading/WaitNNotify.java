package MultiThreading;

import java.util.Scanner;

public class WaitNNotify {
    public static void main(String[] args) {
        WNN wnn = new WNN();
        Thread t1 = new Thread(wnn::produce);
        Thread t2 = new Thread(wnn::consume);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class WNN {
    public void produce() {

        synchronized (this) {
            System.out.println("Producer thread has started");
            try {
                wait(); //отдаем окно и ждем пока не будет вызван notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Producer thread has resumed");
        }
    }

    public void consume() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);

        synchronized (this) {
            System.out.println("waiting for return key pressed");
            sc.nextLine();
            notify();
            System.out.println("SSSS");
        }
    }
}
