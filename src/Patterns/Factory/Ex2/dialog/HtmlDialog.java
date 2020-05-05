package Patterns.Factory.Ex2.dialog;

import Patterns.Factory.Ex2.buttons.Button;
import Patterns.Factory.Ex2.buttons.HtmlButton;

public class HtmlDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
