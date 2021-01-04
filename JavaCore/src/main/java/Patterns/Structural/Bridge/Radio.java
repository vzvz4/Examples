package Patterns.Structural.Bridge;

public class Radio implements Device {
    int volume;
    boolean power;

    public Radio(int volume, boolean power) {
        this.volume = volume;
        this.power = power;
    }

    @Override
    public boolean isEnabled() {
        return power;
    }

    @Override
    public void enable() {
        power = true;
    }

    @Override
    public void disable() {
        power = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int vol) {
        volume = vol;
    }
}
