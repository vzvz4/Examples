package Patterns.Behavioral.Mediator.Ex1;

public class Client {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Component c = new Button(mediator);
        mediator.notifyComponent(c, "Click");
    }
}
