package Patterns.Behavioral.Mediator;

public class Client {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Component c = new Button(mediator);
        c.action();
    }
}
