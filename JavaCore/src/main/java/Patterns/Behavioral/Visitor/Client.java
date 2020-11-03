package Patterns.Behavioral.Visitor;

public class Client {

    public static void main(String[] args) {
        Component leaf = new Leaf(5);
        Component arrayOfLeaf = new Composite(new Leaf(1), new Leaf(3));
        Component arrayOfArrayOfLeaf = new Composite(arrayOfLeaf, leaf);

        Component c = new Composite(leaf, arrayOfLeaf, arrayOfArrayOfLeaf);

        System.out.println(c.execute());
    }
}
