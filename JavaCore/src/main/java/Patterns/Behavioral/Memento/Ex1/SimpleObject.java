package Patterns.Behavioral.Memento.Ex1;

import java.io.*;
import java.util.Base64;

public class SimpleObject implements Originator, Serializable {
    private int value;
    private String name;
    private boolean running;
    private Component component;

    public SimpleObject(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public SimpleObject(int value) {
        this.value = value;
    }

    public void doSomethingUseful(int j) {
        component = new Component(3);
        running = true;
        this.value = j;
        this.name = "Hello world!";
        for (int i = 0; running; i++) {
            if (i == 5) running = false;
            System.out.println("hello");
        }
    }

    @Override
    public String toString() {
        return "SimpleObject{" +
                "value=" + value +
                ", name='" + name + '\'' +
                ", running=" + running +
                ", component=" + component +
                '}';
    }

    public String backup() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            oos.close();
            return Base64.getEncoder().encodeToString(baos.toByteArray());
        } catch (IOException e) {
            return "";
        }
    }

    public void restore(String state) {
        try {
            byte[] data = Base64.getDecoder().decode(state);
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
            SimpleObject simpleObject = (SimpleObject) ois.readObject();
            this.value = simpleObject.value;
            this.name = simpleObject.name;
            this.component = simpleObject.component;
            this.running = simpleObject.running;
            ois.close();
        } catch (ClassNotFoundException e) {
            System.out.print("ClassNotFoundException occurred.");
        } catch (IOException e) {
            System.out.print("IOException occurred.");
        }
    }

//    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        in.defaultReadObject();
//        value = in.readInt();
//        name = (String) in.readObject();
//        running = in.readBoolean();
//        component = (Component) in.readObject();
//    }
//
//    private void writeObject(ObjectOutputStream out) throws IOException {
//        out.defaultWriteObject();
//        out.writeInt(value);
//        out.writeObject(name);
//        out.writeBoolean(running);
//        out.writeObject(component);
//    }
}
