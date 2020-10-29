package Patterns.Behavioral.Visitor.Ex1_Developers;

import Patterns.Behavioral.Visitor.Ex1_Developers.developers.Developer;
import Patterns.Behavioral.Visitor.Ex1_Developers.developers.JuniorDeveloper;
import Patterns.Behavioral.Visitor.Ex1_Developers.projectElements.ClassElements;
import Patterns.Behavioral.Visitor.Ex1_Developers.projectElements.ProjectElement;
import Patterns.Behavioral.Visitor.Ex1_Developers.projectElements.TestElement;

public class Project {
    private ProjectElement[] projectElements = new ProjectElement[] {
         new ClassElements(),
         new TestElement()
    };

    public static void main(String[] args) {
        new Project().writeProject(new JuniorDeveloper());
    }

    public void writeProject(Developer developer) {
        for (ProjectElement projectElement : projectElements) {
            projectElement.beWritten(developer);
        }
    }
}
