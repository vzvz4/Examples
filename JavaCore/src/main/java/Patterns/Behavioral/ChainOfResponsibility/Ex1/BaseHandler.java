package Patterns.Behavioral.ChainOfResponsibility.Ex1;

public abstract class BaseHandler implements Handler {
    private String name;
    private Handler next;

    public BaseHandler(String name) {
        this.name = name;
    }

    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }

    @Override
    public void handleRequest(Request request) {
        if (next != null && canHandle(request)) {
            next.handleRequest(request);
        } else System.out.println("Request handled by handler №: " + this.name);
    }

    private boolean canHandle(Request request) {
        return request.isCanHandlersHandleWithIt();
    }
}
