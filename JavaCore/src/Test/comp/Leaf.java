package Test.comp;

public class Leaf implements Component {
    private int cost;

    public Leaf(int cost) {
        this.cost = cost;
    }

    @Override
    public int execute() {
        return cost;
    }

    @Override
    public void add(Component... components) {

    }
}
