package Patterns.Behavioral.NullObject;

public class Client {
  public static void main(String[] args) {
    AbsEntity absObj = new ReallyEntity();
    AbsEntity nullObj = new NullObjectEntity();

    absObj.doSomething();
    nullObj.doSomething();
  }
}
