package InterfacesExample;


public class App {
    public static void main(String[] args) {
        Info info = new Animal(3);
        Info info2= new Person("Igor");
        Animal animal1 = new Animal(4);
        output(animal1);

    }
    public static void output (Info info) {
        info.showInfo();
    }
}
