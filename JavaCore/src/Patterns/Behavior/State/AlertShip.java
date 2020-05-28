package Patterns.State;

public class AlertShip {
    void doWarn() {
        System.out.println("Alert");
    }
}
class WarningStatus extends AlertShip {
    void doWarn() {
        System.out.println("Warning");
    }
}
class ErrorStatus extends AlertShip {
    void doWarn() {
        System.out.println("Error");
    }
}