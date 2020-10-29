package Patterns.Behavioral.Visitor.Ex2_XMLExporter;

import Patterns.Behavioral.Visitor.Ex2_XMLExporter.elementsToVisit.Cube;
import Patterns.Behavioral.Visitor.Ex2_XMLExporter.elementsToVisit.Pyramid;
import Patterns.Behavioral.Visitor.Ex2_XMLExporter.elementsToVisit.Shape;
import Patterns.Behavioral.Visitor.Ex2_XMLExporter.visitors.VisitorXMLExporter;

public class Client {
    private Shape[] shapes = new Shape[] {
            new Cube(4),
            new Pyramid(3,4)
    };

    public static void main(String[] args) {
        Client c = new Client();
        for (Shape s: c.shapes) {
            s.welcome(new VisitorXMLExporter());
        }
    }
}
