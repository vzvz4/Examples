package InnerClassesExample.Car;

public class Main {

    public static void main(String[] args) {
        ElectroCar car = new ElectroCar(3);
        car.start();
        OtherExample o = new OtherExample();
        //! OtherExample.InnerClass e = new OtherExample.InnerClass();
        OtherExample.NestedClass ns = new OtherExample.NestedClass();
        ElectroCar.Battery battery = new ElectroCar.Battery();

        OtherExample ot = new OtherExample();

        //нет доступа к вложенным приватным классам
    }
}
