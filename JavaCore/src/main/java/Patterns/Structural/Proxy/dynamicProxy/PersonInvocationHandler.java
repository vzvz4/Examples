package Patterns.Structural.Proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class PersonInvocationHandler implements InvocationHandler {
  private Person person;

  public PersonInvocationHandler(Person person) {
    this.person = person;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("hello");
    System.out.println(Arrays.toString(args));
    return method.invoke(person, args);
  }
}
