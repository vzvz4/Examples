package Patterns.Behavioral.Visitor.Ex2_XMLExporter.visitors;

import Patterns.Behavioral.Visitor.Ex2_XMLExporter.elementsToVisit.Cube;
import Patterns.Behavioral.Visitor.Ex2_XMLExporter.elementsToVisit.Pyramid;

public class VisitorXMLExporter implements Visitor{

    @Override
    public void visit(Cube c) {
        int a = (int) c.volume();
        System.out.println("Export to XML Cube volume is " + a);
    }

    @Override
    public void visit(Pyramid p) {
        int a = (int) p.volume();
        System.out.println("Export to XML Pyramid volume is " + a);
    }
}
