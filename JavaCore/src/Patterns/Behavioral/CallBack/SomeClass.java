package Patterns.Behavioral.CallBack;

public class SomeClass {
    public interface CallBack {
        void collingBack();
    }
    CallBack cb;

    public void registerCallBack(CallBack callback){
        this.cb = callback;
    }

    public void doSomething() {
        System.out.println("Working process...");
        cb.collingBack();
    }
}
