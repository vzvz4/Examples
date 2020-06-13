package Patterns.Behavioral.Visitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Composite implements Component {

    private List<Component> componentList;

    public Composite(Component... components) {
        this.componentList = new ArrayList<>();
        this.componentList.addAll(Arrays.asList(components));
    }

    public void add(Component c) {
        componentList.add(c);
    }
    public void remove(Component c) {
        componentList.remove(c);
    }
    public List<Component> getChildren() {
        return componentList;
    }

    @Override
    public int execute() {
        return componentList.stream().mapToInt(Component::execute).sum();
    }
}
