package Test.fab2;


import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Fabric fabric = new PlasticProductFab();
        useProducts(fabric);
    }

    public static void useProducts(Fabric fabric) {
       Product bottle = fabric.createBottle();
       Product cap = fabric.createCap();
       bottle.use();
       cap.use();
    }

}
