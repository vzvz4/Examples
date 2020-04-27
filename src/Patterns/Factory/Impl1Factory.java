package Patterns.Factory;

public class Impl1Factory implements ServiceFactory {

    @Override
    public Service getService() {
        return new Impl1();
    }
}
