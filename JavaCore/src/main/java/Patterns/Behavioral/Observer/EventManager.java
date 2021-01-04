package Patterns.Behavioral.Observer;

import java.util.List;

public class EventManager implements Publisher{

    private List<Subscriber> listeners;

    @Override
    public void notifySubs() {
        listeners.forEach(x -> x.update(""));
    }

    @Override
    public void unsubscribe(Subscriber s) {

    }

    @Override
    public void subscribe(Subscriber s) {

    }
}
