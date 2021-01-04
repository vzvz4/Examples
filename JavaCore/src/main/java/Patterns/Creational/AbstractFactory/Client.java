package Patterns.Creational.AbstractFactory;

import Patterns.Creational.AbstractFactory.fabric.WebWidgetFactory;
import Patterns.Creational.AbstractFactory.fabric.WidgetFactory;
import Patterns.Creational.AbstractFactory.scroll.ScrollBar;
import Patterns.Creational.AbstractFactory.window.Window;

public class Client {
    private WidgetFactory widgetFactory;
    private Window window;
    private ScrollBar scrollBar;

    public Client(WidgetFactory widgetFactory) {
        this.widgetFactory = widgetFactory;
    }

    public void createClient() {
        window = widgetFactory.createWindow();
        scrollBar = widgetFactory.createScrollBar();
    }

    public void useClient() {
        window.action();
        scrollBar.action();
    }

    public static void main(String[] args) {
        Client webClient = new Client(new WebWidgetFactory());
        webClient.createClient();
        webClient.useClient();
    }
}
