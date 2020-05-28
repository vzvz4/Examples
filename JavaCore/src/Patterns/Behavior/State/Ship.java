package Patterns.State;

public class Ship {
    AlertShip al = new AlertShip();

    void doAlarm() {
        al.doWarn();
    }

    void changeAlarm() {
        al = new WarningStatus();
    }

    public static void main(String[] args) {
        Ship ship = new Ship();
        ship.doAlarm();
        ship.changeAlarm();
        ship.doAlarm();
    }
}
