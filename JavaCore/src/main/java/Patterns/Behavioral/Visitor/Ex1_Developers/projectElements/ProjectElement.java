package Patterns.Behavioral.Visitor.Ex1_Developers.projectElements;

import Patterns.Behavioral.Visitor.Ex1_Developers.developers.Developer;

// Interface to visit elements
public interface ProjectElement {
    void beWritten(Developer developer);
}
