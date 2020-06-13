package Patterns.Behavioral.Visitor.Ex1_Developers.projectElements;

import Patterns.Behavioral.Visitor.Ex1_Developers.developers.Developer;

public class ClassElements implements ProjectElement {

    @Override
    public void beWritten(Developer developer) {
        developer.create(this);
    }

}
