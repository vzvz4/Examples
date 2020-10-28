package inheritance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Cat extends Pet {

//  @JsonProperty("it's not name!")
  private String name;

  @JsonIgnore
  private String color;

  @JsonDeserialize(as = LinkedList.class) // ArrayList as default
//  Если лист содержит интерфейсы, то можно (и нужно) указать какие :
//  @JsonDeserialize(contentAs=ValueTypeImpl.class) // для List
//  @JsonDeserialize(keyAs=KeyTypeImpl.class) // для Map
  private List<Cat> cats;

  public Cat(String name, String color) {
    this.name = name;
    this.color = color;
  }

  public Cat(String name, String color, List<Cat> cats) {
    this.name = name;
    this.color = color;
    this.cats = cats;
  }

  public Cat() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public List<Cat> getCats() {
    return cats;
  }

  public void setCats(List<Cat> cats) {
    this.cats = cats;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Cat cat = (Cat) o;
    return name.equals(cat.name) &&
        color.equals(cat.color);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, color);
  }

  @Override
  public String toString() {
    return "inheritance.Cat{" +
        "name='" + name + '\'' +
        ", color='" + color + '\'' +
        ", cats=" + cats +
        '}';
  }
}
