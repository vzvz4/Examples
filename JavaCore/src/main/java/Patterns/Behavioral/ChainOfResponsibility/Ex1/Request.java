package Patterns.Behavioral.ChainOfResponsibility.Ex1;

public class Request {
    private boolean canHandlersHandleWithIt;

    public Request(boolean canHandlersHandleWithIt) {
        this.canHandlersHandleWithIt = canHandlersHandleWithIt;
    }

    public boolean isCanHandlersHandleWithIt() {
        return canHandlersHandleWithIt;
    }
}
