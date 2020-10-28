package Patterns.Creational.Factory.Ex1;

public class Factory {
    public static void serviceConsumer(ServiceFactory sf) {
        Service s = sf.getService();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(new Impl1Factory());
    }
}
