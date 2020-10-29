package Patterns.Behavioral.Visitor.Ex2_XMLExporter.elementsToVisit;

import Patterns.Behavioral.Visitor.Ex2_XMLExporter.visitors.Visitor;

public interface Shape {
    float volume();
    void welcome(Visitor v);
}
