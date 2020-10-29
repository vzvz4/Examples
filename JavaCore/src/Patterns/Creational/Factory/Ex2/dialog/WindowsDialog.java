package Patterns.Creational.Factory.Ex2.dialog;

import Patterns.Creational.Factory.Ex2.buttons.Button;
import Patterns.Creational.Factory.Ex2.buttons.WindowsButton;

public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
