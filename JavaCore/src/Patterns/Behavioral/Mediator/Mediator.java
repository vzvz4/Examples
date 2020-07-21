package Patterns.Behavioral.Mediator;

public interface Mediator {
    void notifyComponent(Component c, String event);
}
