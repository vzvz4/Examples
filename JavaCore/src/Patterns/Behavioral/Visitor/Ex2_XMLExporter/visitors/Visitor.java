package Patterns.Behavioral.Visitor.Ex2_XMLExporter.visitors;

import Patterns.Behavioral.Visitor.Ex2_XMLExporter.elementsToVisit.Cube;
import Patterns.Behavioral.Visitor.Ex2_XMLExporter.elementsToVisit.Pyramid;

public interface Visitor {
    void visit(Cube c);
    void visit(Pyramid p);
}
