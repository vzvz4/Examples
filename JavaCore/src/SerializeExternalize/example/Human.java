package SerializeExternalize.example;

import java.io.Serializable;

public class Human {
  private String sex;

  public Human() {
    System.out.println("Human Constructor invoked");
  }
  public Human(String sex) {
    System.out.println("Human constructor");
    this.sex = sex;
  }
}
