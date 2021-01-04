package Patterns.Structural.Proxy.dynamicProxy;

import java.lang.reflect.Proxy;

public class Client {
  public static void main(String[] args) {
    Man man = new Man("Jam", 12, "Owslo", "Russia");
    ClassLoader cl = man.getClass().getClassLoader();
    Class<?>[] interfaces = man.getClass().getInterfaces();
    Person proxy = (Person) Proxy.newProxyInstance(cl, interfaces, new PersonInvocationHandler(man));
    System.out.println(proxy.getClass());
    proxy.introduce("E");
  }
}
