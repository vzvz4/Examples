package Patterns.Behavioral.Mediator.Ex2;

public class AuthDialog implements Mediator {
    private Button okButton;

    private TextBox textBox;
    private TextBox passwordTextBox;

    private CheckBox checkBox;

    public AuthDialog(Button okButton, TextBox textBox, CheckBox checkBox) {
        this.okButton = okButton;
        this.textBox = textBox;
        this.checkBox = checkBox;
        passwordTextBox = new TextBox() {
            @Override
            public String getText() {
                return "Password 123iiiss";
            }
        };
        passwordTextBox.setDialog(this);
    }

    @Override
    public void notify(Component sender, String event) {
        if (sender instanceof Button) {
            System.out.println("Button clicked");
            System.out.println("Doing business logic");
            String name = textBox.getText();
            String password = passwordTextBox.getText();
            System.out.printf("Auth request initializing: %s, %s\n", name, password);
            Thread t = new Thread(() -> {
                try {
                    String s = ".";
                    for (int i = 0; i < 7; i++) {
                        Thread.sleep(1000);
                        System.out.print(s);
                    }
                    System.out.println();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Auth is OK, status code: 200");
        } else if (sender instanceof TextBox) {
            textBox.setText(event);
        } else if (sender instanceof CheckBox) {
            checkBox.click();
        }
    }
}
