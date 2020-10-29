package Patterns.Structural.Bridge;

public class Remote {
    private Device device;

    public Remote(Device device) {
        this.device = device;
    }

    public void togglePower() {
        device.enable();
    }

    public void volumeUp(int vol) {
        device.setVolume(vol);
    }

    public void volumeDown(int vol) {
        device.setVolume(vol);
    }
}
