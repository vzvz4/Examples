package Patterns.Behavioral.Mediator.Ex2;

public class Button extends Component {

    public Button(Mediator dialog) {
        super(dialog);
    }

    public Button() {
    }

    @Override
    protected void click() {
        dialog.notify(this, "Click");
    }
}
