package Patterns.Behavioral.Observer.Ex1;

import java.util.ArrayList;
import java.util.List;

public class EventManager implements Publisher {

    private final List<Subscriber> listeners;

    public EventManager() {
        listeners = new ArrayList<>();
    }

    @Override
    public void notifySubs(String event) {
        listeners.forEach(x -> x.update(event));
    }

    @Override
    public void unsubscribe(Subscriber s) {

    }

    @Override
    public void subscribe(Subscriber s) {
        listeners.add(s);
    }
}
