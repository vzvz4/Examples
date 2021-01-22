package Patterns.Behavioral.Mediator.Ex1;

public abstract class Component {
    protected Mediator mediator;

    public Component(Mediator mediator) {
        this.mediator = mediator;
    }
    public abstract void action();
}
