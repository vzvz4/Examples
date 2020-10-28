package Patterns.Creational.Factory.Ex1;

public class Impl1Factory implements ServiceFactory {

    @Override
    public Service getService() {
        return new Impl1();
    }
}
