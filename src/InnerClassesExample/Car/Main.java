package InnerClassesExample.Car;

public class Main {

    public static void main(String[] args) {
        ElectroCar car = new ElectroCar(3);
        car.start();

        ElectroCar.Battery battery = new ElectroCar.Battery();

        OtherExample ot = new OtherExample();
        //нет доступа к вложенным приватным классам
    }
}
