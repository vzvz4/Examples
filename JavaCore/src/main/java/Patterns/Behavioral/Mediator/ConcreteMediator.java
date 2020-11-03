package Patterns.Behavioral.Mediator;

public class ConcreteMediator implements Mediator {

    @Override
    public void notifyComponent(Component c, String event) {
        if (c instanceof Button && event.equals("Click"))
            System.out.println("Button clicked");
    }
}
