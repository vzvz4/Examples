package Patterns.Behavioral.Observer.Ex1;

public interface Publisher {
    void notifySubs(String event);
    void unsubscribe(Subscriber s);
    void subscribe(Subscriber s);
}
