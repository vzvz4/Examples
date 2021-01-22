package Patterns.Behavioral.Mediator.Ex1;

public class Button extends Component {

    public Button(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void action() {
        mediator.notifyComponent(this, "Click");
    }

}
