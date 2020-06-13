package Patterns.Behavior.Visitor.Ex1_Developers.developers;

import Patterns.Behavior.Visitor.Ex1_Developers.projectElements.ClassElements;
import Patterns.Behavior.Visitor.Ex1_Developers.projectElements.TestElement;

public interface Developer {
    void create(TestElement testElement);
    void create(ClassElements classElements);
}
