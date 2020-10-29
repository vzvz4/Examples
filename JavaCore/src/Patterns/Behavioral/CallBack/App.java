package Patterns.Behavioral.CallBack;

public class App implements SomeClass.CallBack {
    @Override
    public void collingBack() {
        System.out.println("CallingBack");
    }

    public static void main(String[] args) {
        SomeClass sm = new SomeClass();
        App app = new App();
        sm.registerCallBack(app);
        sm.doSomething();
    }
}
