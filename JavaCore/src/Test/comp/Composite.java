package Test.comp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Composite implements Component {

    private List<Component> components;

    public Composite(List<Component> components) {
        this.components = components;
    }

    public Composite(Component... c) {
        components = new ArrayList<>();
        components.addAll(Arrays.asList(c));
    }

    @Override
    public int execute() {
        return components.stream().mapToInt(Component::execute).sum();
    }

    @Override
    public void add(Component... components) {
        this.components.addAll(Arrays.asList(components));
    }

    public void add(Component a) {
        components.add(a);
    }



}
