package SerializeExternalize.example;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Externalize {
  public static class Employee extends Human implements Externalizable {
    private static final int serialVersionUID = 1566;
    private String name;
    private int age;

    public Employee(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public Employee(String name, int age, String sex) {
      super(sex);
      System.out.println("Employee constructor");
      this.name = name;
      this.age = age;
    }

    public Employee() {
    }

    @Override
    public String toString() {
      return "Employee{" +
          "name='" + name + '\'' +
          ", age=" + age +
          '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
      out.write(name.getBytes());
      out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
      char j = ((char) in.read());
      char a = ((char) in.read());
      char c = ((char) in.read());
      char k = ((char) in.read());
      String name = new String(new char[]{j,a,c,k});
      this.name = name;
      age = in.readInt();
    }
  }
}
