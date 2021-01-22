package Patterns.Behavioral.Observer.Ex1;

public class EmailAlertsListener implements Subscriber {

    @Override
    public void update(String fileName) {
        System.out.println("Updated: " + fileName);
    }
}
