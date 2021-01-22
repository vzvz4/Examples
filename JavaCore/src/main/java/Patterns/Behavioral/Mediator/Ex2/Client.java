package Patterns.Behavioral.Mediator.Ex2;

public class Client {
    public static void main(String[] args) {
        Button button = new Button();
        TextBox text = new TextBox();
        CheckBox check = new CheckBox();

        AuthDialog authDialog = new AuthDialog(button, text, check);
        button.setDialog(authDialog);

        button.click();

    }
}

