package Patterns.Behavioral.ChainOfResponsibility.Ex1;

public class Client {
    public static void main(String[] args) {
        Request request1 = new Request(true);
        Request request2 = new Request(false);

        Handler handler1 = new ConcreteHandler("1");
        Handler handler2 = new ConcreteHandler("2");
        Handler handler3 = new ConcreteHandler("3");

        handler1.setNext(handler2);
        handler2.setNext(handler3);

        handler1.handleRequest(request1);
        handler1.handleRequest(request2);

    }
}
