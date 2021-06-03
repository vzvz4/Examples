package Patterns.Behavioral.Visitor.Ex1_Developers.developers;

import Patterns.Behavioral.Visitor.Ex1_Developers.projectElements.ClassElements;
import Patterns.Behavioral.Visitor.Ex1_Developers.projectElements.TestElement;

// Visitor
public interface Developer {
    void create(TestElement testElement);
    void create(ClassElements classElements);
}
