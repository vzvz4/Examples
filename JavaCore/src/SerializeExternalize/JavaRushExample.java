package SerializeExternalize;

import java.io.*;

public class JavaRushExample implements Serializable {

  /**
   * Пример описывает тот случай, когда при сериализации объекта мы хотим,
   * чтобы из суперкласса этого объекта записывались только определенные поля этого суперкласса.
   */
  public static void main(String[] args) {
    String f = "C:\\Users\\vzvz4\\Desktop\\PAPKA\\GitHub\\FormatterEx\\JavaCore\\src\\SerializeExternalize\\1.txt";
    try (ByteArrayOutputStream outA = new ByteArrayOutputStream();
         FileOutputStream outF = new FileOutputStream(f);
         ObjectOutputStream out = new ObjectOutputStream(outF)) {
      JavaRushExample m = new JavaRushExample();
      B b = m.new B("Green", "Oleg", 15);
      out.writeObject(b);
      out.flush();
      try (ByteArrayInputStream inA = new ByteArrayInputStream(outA.toByteArray());
           FileInputStream inF = new FileInputStream(f);
           ObjectInputStream in = new ObjectInputStream(inF)) {

        B o = (B) in.readObject();
        System.out.println(o);
      }
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  static class A {
    protected String color;

    public A(String color) {
      System.out.println("NonDef");
      this.color = color;
    }

    /**
     * т.к. этот суперкласс не имплементирует интерфейс Serializable, то
     * при возвращении объекта вызывающей стороне будет вызван конструктор по умолчанию, иначе,
     * если класс поддерживает Serializable, будет вызыватся конструктор с параметрами, если такой есть
     * и объект был создан с помощью него
     */
    public A() {
      System.out.println("Def");
    }
  }

  class B extends A implements Serializable {
    String name;
    int age;

    public B(String color, String name, int age) {
      super(color);
      this.name = name;
      this.age = age;
    }

    @Override
    public String toString() {
      return "B{" +
          "color='" + color + '\'' +
          ", name='" + name + '\'' +
          ", age=" + age +
          '}';
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      out.writeObject(name);
      out.writeObject(color);
      out.writeInt(age);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      name = (String) in.readObject();
      color = (String) in.readObject();
      age = in.readInt();
    }

    public Object readResolve() {
      return this;
    }

  }
}
