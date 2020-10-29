package Patterns.Behavioral.Visitor.Ex2_XMLExporter.elementsToVisit;

import Patterns.Behavioral.Visitor.Ex2_XMLExporter.visitors.Visitor;

public class Cube implements Shape{
    private int edge;

    public Cube(int edge) {
        this.edge = edge;
    }

    @Override
    public float volume() {
        return edge * edge * edge;
    }

    @Override
    public void welcome(Visitor v) {
        v.visit(this);
    }
}
