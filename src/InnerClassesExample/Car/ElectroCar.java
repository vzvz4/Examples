package InnerClassesExample.Car;

public class ElectroCar {
    private int id;
    private static int test;

    public ElectroCar(int id) {
        this.id = id;
    }

    //вложенный статический класс (nested)
//    для создания объекта статического внутреннего класса не нужен объект внешнего класса
//    из объекта вложенного класса нельзя обращаться к нестатическим членам внешнего класса
    public static class Battery{
        public void charge() {
            System.out.println("Buttery is charging");
        }
    }

    //Нестатический вложенный или внутренний класс (inner), обычно используются с модификатором private
    //Inner класс не может содержать статических полей
    private class Motor {
        public void startMotor() {
            System.out.println("Car N"+id + " Motor Started");
        }
    }

    public void start() {
        Motor motor = new Motor();
        motor.startMotor();

        //поля могут использоваться вложенным классом только с модификатором final
        final int x = 1;

        class SomeClass{
            public void someMethod(){
                System.out.println("SomeMethod for car N"+id);
                System.out.println("SomeMethod arg is "+x);
            }
        }

        SomeClass someObject = new SomeClass();
        System.out.println("Car N"+id + " Started");
        someObject.someMethod();
        someTest(someObject);
    }
    public void someTest(Object ob) {
        System.out.println(ob.hashCode());
    }
}
