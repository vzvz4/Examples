package Patterns.Creational.Prototype;

public class Client {
    public static void main(String[] args) {
        Prototype p = new PrototypeImpl("Oleg");
        Prototype p2 = p.clone();
        Prototype p3 = new SubClass("Smoke", "Smeegol");
        Prototype p4 = p3.clone();
        System.out.println(p2);
        System.out.println(p4);
    }
}
