package Patterns.Structural.Bridge;

public class Client {
    public static void main(String[] args) {
        Device d = new Radio(0,false);
        Remote r = new Remote(d);
        r.togglePower();
        r.volumeUp(10);
        System.out.println(d.getVolume());
        System.out.println(d.isEnabled());
    }
}
