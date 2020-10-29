package Patterns.Creational.AbstractFactory.fabric;

import Patterns.Creational.AbstractFactory.scroll.ScrollBar;
import Patterns.Creational.AbstractFactory.window.Window;

public abstract class WidgetFactory {
    public abstract Window createWindow();
    public abstract ScrollBar createScrollBar();
}
