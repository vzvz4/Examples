package SerializeExternalize.example;

import java.io.Serializable;

public class Serialize {
  public static class Person extends Human implements Serializable {
    private static final long serialVersionUID = 1233;
    private String name;
    private int age;

    public Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public Person(String name, int age, String sex) {
      super(sex);
      System.out.println("Person constructor");
      this.name = name;
      this.age = age;
    }

    @Override
    public String toString() {
      return "Person{" +
          "name='" + name + '\'' +
          ", age=" + age +
          '}';
    }
  }
}
