package SerializeExternalize.example;

import java.io.*;

public class Client {
  public static void main(String[] args) {

    String file = ".\\JavaCore\\src\\SerializeExternalize\\1.txt";
    String temp = ".\\JavaCore\\src\\SerializeExternalize\\temp.txt";
    try (ObjectOutputStream outObj = new ObjectOutputStream(new FileOutputStream(file));
         ObjectInputStream inObj = new ObjectInputStream(new FileInputStream(file))) {
      writeSerialPerson(outObj);
      readSerialPerson(inObj);

//      writeExternalEmployee(outObj);
//      readExternalEmployee(inObj);
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static void writeSerialPerson(ObjectOutputStream out) throws IOException, ClassNotFoundException {
    Serialize.Person person = new Serialize.Person("Lena", 34);
    out.writeObject(person);
    out.flush();
  }

  private static void readSerialPerson(ObjectInputStream in) throws IOException, ClassNotFoundException {
    Serialize.Person readPerson = (Serialize.Person) in.readObject();
    long serialVersionID = ObjectStreamClass.lookup(readPerson.getClass()).getSerialVersionUID();
    System.out.println("SerialUID Person --> " + serialVersionID);
    System.out.println("Person: " + readPerson);
  }

  private static void writeExternalEmployee(ObjectOutputStream out) throws IOException {
    Externalize.Employee employee = new Externalize.Employee("Jack", 56);
    out.writeObject(employee);
    out.flush();
  }

  private static void readExternalEmployee(ObjectInputStream in) throws IOException, ClassNotFoundException {
    Externalize.Employee readEmployee = (Externalize.Employee) in.readObject();
    long serialVersionID2 = ObjectStreamClass.lookup(readEmployee.getClass()).getSerialVersionUID();
    System.out.println("SerialUID Employee --> " + serialVersionID2);
    System.out.println("Employee: " + readEmployee);
  }
}
