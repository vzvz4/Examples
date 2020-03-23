package ExtendsExampleShapeBox.UsingInterface;

public class Box implements Shape {
    int h;
    int volume;
    @Override
    public int getVolume() {
        return volume = h*h*h;
    }
}
