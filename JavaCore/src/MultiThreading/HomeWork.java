package MultiThreading;

import java.util.Arrays;

public class HomeWork {

    private static final int SIZE = 10000000;
    private static final int HALF = SIZE / 2;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("_________Выполнение метода №1");
        mathArr1();
        System.out.println("_________Выполнение метода №2");
        mathArr2();
    }

    static void mathArr1() {
        float[] arr = new float[SIZE];

        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Общее время выполнения метода №1 заняло: " + (System.currentTimeMillis() - a));
    }


    static void mathArr2() throws InterruptedException {
        float[] arr = new float[SIZE];
        float[] arrLeft = new float[HALF];
        float[] arrRight = new float[HALF];
        Object lock1 = new Object();
        Object lock2 = new Object();

        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();
        System.arraycopy(arr, HALF, arrRight, 0, HALF);
        System.arraycopy(arr, 0, arrLeft, 0, HALF);
        System.out.println("Время разбивки массива на 2 части: " + (System.currentTimeMillis() - a));

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                long a1 = System.currentTimeMillis();
                for (int i = 0; i < arrRight.length; i++) {
                    arrRight[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.println("Время просчета правой части: " + (System.currentTimeMillis() - a1));
            }
        });

        Thread t2 = new Thread(() -> {
                long a12 = System.currentTimeMillis();
            synchronized (lock2) {
                for (int i = 0; i < arrLeft.length; i++) {
                    arrLeft[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.println("Время просчета левой части: " + (System.currentTimeMillis() - a12));
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long b = System.currentTimeMillis();
        System.arraycopy(arrLeft, 0, arr, 0, HALF);
        System.arraycopy(arrRight, 0, arr, HALF, HALF);
        System.out.println("Склейка массивов заняла: " + (System.currentTimeMillis() - b));

        System.out.println("Новое значение исходного массива в позиции arr[9000000] = " + arr[9000000]);
        System.out.println("Общее время выполнения метода №2 заняло: " + (System.currentTimeMillis() - a));
    }
}
