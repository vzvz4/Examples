package Patterns.Structural.Bridge;

public interface Device {
    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int vol);
}
