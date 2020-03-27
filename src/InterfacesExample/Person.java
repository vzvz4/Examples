package InterfacesExample;

public class Person implements Info{
    public String name;

    public Person(String name) {
        this.name = name;
    }

    void sayHello() {
        System.out.println("Hi");
    }

    @Override
    public void showInfo() {
        System.out.println("Info "+name);
    }
}
