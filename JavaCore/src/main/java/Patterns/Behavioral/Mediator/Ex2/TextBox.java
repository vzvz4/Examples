package Patterns.Behavioral.Mediator.Ex2;

public class TextBox extends Component {

    public TextBox(Mediator dialog) {
        super(dialog);
    }

    public TextBox() {
    }

    public void setText(String text) {
        dialog.notify(this, text);
    }

    public String getText() {
        System.out.println("Getting text from text field...");
        return "Field value: Gregor";
    }
}
