package Patterns.Creational.Factory.Ex2.dialog;

import Patterns.Creational.Factory.Ex2.buttons.Button;

public abstract class Dialog {

    public void renderWindow() {
        // ... остальной код диалога ...

        Button okButton = createButton();
        System.out.println(okButton.getClass().getSimpleName());
        okButton.render();
    }

    /**
     * Подклассы будут переопределять этот метод, чтобы создавать конкретные
     * объекты продуктов, разные для каждой фабрики.
     */
    public abstract Button createButton();
}
