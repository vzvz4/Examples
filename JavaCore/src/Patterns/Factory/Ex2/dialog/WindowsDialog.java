package Patterns.Factory.Ex2.dialog;

import Patterns.Factory.Ex2.buttons.Button;
import Patterns.Factory.Ex2.buttons.WindowsButton;

public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
