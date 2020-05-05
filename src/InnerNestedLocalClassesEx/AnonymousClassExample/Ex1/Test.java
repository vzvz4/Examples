package InnerNestedLocalClassesEx.AnonymousClassExample.Ex1;

public class Test {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.eat();
        OtherAnimal otherAnimal = new OtherAnimal();
        otherAnimal.eat();

        Animal animal1 = new Animal() {
            @Override
            public void eat() {
                System.out.println("Anonymous animal is eating");
            }
        };
        animal1.eat();
        AbleToEat ableToEat = new OtherAnimal();
        ableToEat.eat();
        AbleToEat ableToEat1 = () -> System.out.println("Interface Animal is eating...");
        ableToEat1.eat();
    }
}
