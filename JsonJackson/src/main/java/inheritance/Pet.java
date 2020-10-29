package inheritance;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type")
@JsonSubTypes({
    @JsonSubTypes.Type(value=Cat.class, name="cat"),
    @JsonSubTypes.Type(value=Dog.class, name="dog")
})
public class Pet {
  private String name;
  private int age;

  public Pet() {
  }

  public Pet(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
