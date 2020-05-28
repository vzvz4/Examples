package Test.fab2;

public class PlasticProductFab implements Fabric {

    @Override
    public Bottle createBottle() {
        return new PlasticBottle();
    }

    @Override
    public Cap createCap() {
        return new PlasticCap();
    }

}
