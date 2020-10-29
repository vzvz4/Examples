package Patterns.Creational.Prototype;

public class SubClass extends PrototypeImpl {
    private String field2;

    public SubClass(String field1, String field2) {
        super(field1);
        this.field2 = field2;
    }

    @Override
    public Prototype clone() {
        return new SubClass(field1, field2);
    }

    @Override
    public String toString() {
        return "SubClass{" +
                "field2='" + field2 + '\'' +
                ", field1='" + field1 + '\'' +
                '}';
    }
}
