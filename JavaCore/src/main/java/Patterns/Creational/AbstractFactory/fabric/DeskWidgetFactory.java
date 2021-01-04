package Patterns.Creational.AbstractFactory.fabric;

import Patterns.Creational.AbstractFactory.scroll.DeskScroll;
import Patterns.Creational.AbstractFactory.scroll.ScrollBar;
import Patterns.Creational.AbstractFactory.window.DeskWindow;
import Patterns.Creational.AbstractFactory.window.Window;

public class DeskWidgetFactory extends WidgetFactory{
    //можно использовать singleton
    private static DeskWindow deskWindow;
    private static ScrollBar deskScrollBar;
    static {
        deskWindow = new DeskWindow();
        deskScrollBar = new DeskScroll();
    }


    @Override
    public Window createWindow() {
        return deskWindow;
    }

    @Override
    public ScrollBar createScrollBar() {
        return deskScrollBar;
    }
}
