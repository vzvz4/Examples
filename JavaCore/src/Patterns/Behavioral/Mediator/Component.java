package Patterns.Behavioral.Mediator;

public abstract class Component {
    protected Mediator mediator;

    public Component(Mediator mediator) {
        this.mediator = mediator;
    }
    public abstract void action();
}
