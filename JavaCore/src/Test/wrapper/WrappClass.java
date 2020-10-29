package Test.wrapper;

public class WrappClass extends Class {
  private Class c;

  public WrappClass(Class c) {
    super(c.field, c.data);
    this.c = c;
  }
  private void doSomeAdditions() {
    System.out.println("Altered Method");
  }

  @Override
  public void doSomeAction() {
    doSomeAdditions();
    c.doSomeAction();
  }
}
