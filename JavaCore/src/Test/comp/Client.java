package Test.comp;

import java.util.Arrays;

public class Client {

    public static void main(String[] args) {
        Component c = new Leaf(5);
        Component bunchOfC = new Composite(c,new Leaf(4), new Leaf(3));
        Component bunchOfBunchOfC = new Composite(c, bunchOfC, new Composite(new Leaf(1), new Leaf(2)));

        Component[] arr = new Component[]{new Leaf(2), new Composite(new Leaf(2))};
        //bunchOfBunchOfC.add(arr);
        System.out.println(getCost(c, bunchOfBunchOfC,bunchOfBunchOfC));
    }

    public static int getCost(Component... components) {
        return Arrays.stream(components).mapToInt(Component::execute).sum();
    }


}
