package ExtendsExampleShapeBox.UsingInterface;

interface Shape extends Comparable<Shape> {
    int getVolume();
    @Override
    default int compareTo(Shape other) {
        return Integer.compare(getVolume(), other.getVolume());
    }
}
