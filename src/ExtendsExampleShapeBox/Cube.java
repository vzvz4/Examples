package ExtendsExampleShapeBox;

public class Cube extends Shape{

    Cube (int h) {
        super(h);
    }

    @Override
    int getVolume() {
        return volume = h*h*h;
    }

}
