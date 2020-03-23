package InnerClassesExample.Car;

public class Main {

    public static void main(String[] args) {
        ElectroCar car = new ElectroCar(3);
        car.start();

        ElectroCar.Battery battery = new ElectroCar.Battery();
    }
}
