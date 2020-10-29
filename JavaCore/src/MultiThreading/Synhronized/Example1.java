package MultiThreading.Synhronized;

public class Example1 {
    public static void main(String[] args) {
        Example1 e1 = new Example1();
        System.out.println("Start");

        new Thread(e1::method2).start();
        new Thread(() -> e1.method1()).start();
    }
    public synchronized void method1() {
        System.out.println("M1Meth1");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("M2Meth1");
    }
    public synchronized void method2() {
        System.out.println("M1Meth2");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("M2Meth2");
    }
}
