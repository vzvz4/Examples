package Patterns.Behavioral.Observer;

import java.util.function.Consumer;

public interface Publisher {
    void notifySubs();
    void unsubscribe(Subscriber s);
    void subscribe(Subscriber s);
}
