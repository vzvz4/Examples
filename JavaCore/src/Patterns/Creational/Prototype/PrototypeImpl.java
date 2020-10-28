package Patterns.Creational.Prototype;

public class PrototypeImpl implements Prototype {
    protected String field1;

    public PrototypeImpl(String field1) {
        this.field1 = field1;
    }

    @Override
    public Prototype clone() {
        return new PrototypeImpl(field1);
    }

    @Override
    public String toString() {
        return "PrototypeImpl{" +
                "field1='" + field1 + '\'' +
                '}';
    }
}
