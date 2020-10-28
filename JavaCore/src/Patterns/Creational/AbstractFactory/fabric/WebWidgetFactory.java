package Patterns.Creational.AbstractFactory.fabric;

import Patterns.Creational.AbstractFactory.scroll.ScrollBar;
import Patterns.Creational.AbstractFactory.scroll.WebScroll;
import Patterns.Creational.AbstractFactory.window.WebWindow;
import Patterns.Creational.AbstractFactory.window.Window;

public class WebWidgetFactory extends WidgetFactory{

    @Override
    public Window createWindow() {
        return new WebWindow();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new WebScroll();
    }
}
