package ExtendsExampleShapeBox;

abstract class Shape {
    int h;
    int volume;

    Shape(int h) {
    this.h = h;
    }

    abstract int getVolume();
}
