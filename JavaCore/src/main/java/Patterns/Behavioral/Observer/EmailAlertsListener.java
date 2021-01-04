package Patterns.Behavioral.Observer;

public class EmailAlertsListener implements Subscriber {

    @Override
    public void update(String fileName) {
        System.out.println("Updated: " + fileName);
    }
}
