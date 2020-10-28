package Patterns.Behavioral.Visitor.Ex2_XMLExporter.elementsToVisit;

import Patterns.Behavioral.Visitor.Ex2_XMLExporter.visitors.Visitor;

public class Pyramid implements Shape {
    private float base;
    private float height;

    public Pyramid(float base, float height) {
        this.base = base;
        this.height = height;
    }


    @Override
    public float volume() {
        return base * base * height;
    }

    @Override
    public void welcome(Visitor v) {
        v.visit(this);
    }
}
