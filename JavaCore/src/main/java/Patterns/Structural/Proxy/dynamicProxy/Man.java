package Patterns.Structural.Proxy.dynamicProxy;

public class Man implements Person {

  // Представим, что этот класс мы получили в составе готовой JAR-библиотеки и не можем просто взять и переписать его код.
  // Тем не менее, нам нужно изменить его поведение. К примеру, мы не знаем, какой именно метод будет вызван у нашего
  // объекта, а потому хотим, чтобы при вызове любого из них человек сначала говорил «Привет!» (никто не любит невежливых).
  private String name;
  private int age;
  private String city;
  private String country;

  public Man(String name, int age, String city, String country) {
    this.name = name;
    this.age = age;
    this.city = city;
    this.country = country;
  }

  @Override
  public void introduce(String intro) {
    System.out.println(intro);
    System.out.println(this.name);
  }

  @Override
  public void sayAge() {
    System.out.println(this.age);
  }

  @Override
  public void sayFrom() {
    System.out.println(this.city + " " + this.country);
  }
}
