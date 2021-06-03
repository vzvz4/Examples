package Patterns.Behavioral.Visitor.Ex1_Developers.developers;

import Patterns.Behavioral.Visitor.Ex1_Developers.projectElements.ClassElements;
import Patterns.Behavioral.Visitor.Ex1_Developers.projectElements.TestElement;

// Concrete visitor
public class SeniorDeveloper implements Developer {

    @Override
    public void create(TestElement testElement) {
        System.out.println("Cool tests");
    }

    @Override
    public void create(ClassElements classElements) {
        System.out.println("cool classes");
    }
}
