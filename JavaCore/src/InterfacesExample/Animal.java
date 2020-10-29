package InterfacesExample;

public class Animal implements Info{
    public int id;
    public Animal(int id){
        this.id = id;
    }
    void sleep() {
        System.out.println("Im sleeping");
    }

    @Override
    public void showInfo() {
        System.out.println("Info "+id);
    }
}
