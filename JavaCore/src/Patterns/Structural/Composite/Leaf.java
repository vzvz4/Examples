package Patterns.Structural.Composite;

public class Leaf implements Component {
    private int cost;

    public Leaf(int cost) {
        this.cost = cost;
    }

    @Override
    public int execute() {
        return cost;
    }
}
