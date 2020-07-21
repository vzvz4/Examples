package Patterns.Behavioral.Mediator;

public class Button extends Component {

    public Button(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void action() {
        mediator.notifyComponent(this, "Click");
    }

}
