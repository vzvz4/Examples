package Test.wrapper;

public class Class {
  protected String field;
  protected int data;

  public Class(String field, int data) {
    this.field = field;
    this.data = data;
  }

  public void doSomeAction() {
    System.out.println("Hello world " + field);
  }
}
