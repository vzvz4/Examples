package Patterns.Behavioral.Mediator.Ex2;

public abstract class Component {
    protected Mediator dialog;

    public Component(Mediator dialog) {
        this.dialog = dialog;
    }

    public Component() {
    }

    protected void click() {
        System.out.println("Clicked");
    }

    protected void keyPressed() {
        System.out.println("Pressed");
    }

    public void setDialog(Mediator dialog) {
        this.dialog = dialog;
    }
}
