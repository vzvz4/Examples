package ExtendsExampleShapeBox;

public class Box extends Shape {

    private int placeTaken;

    Box(int h) {
        super(h);
    }

    public int getPlaceTaken() {
        return placeTaken;
    }

    @Override
    int getVolume() {
        return volume = h * h * h;
    }

    boolean add(Shape s) {
        placeTaken += s.getVolume();
        return placeTaken < this.volume;
    }
}
