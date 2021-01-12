package Patterns.Behavioral.ChainOfResponsibility.Ex1;

public interface Handler {
    void setNext(Handler handler);
    void handleRequest(Request request);
}
