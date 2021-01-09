package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

public class Reader {
   public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
      Reader reader = new Reader();
      ClassLoader cl = reader.getClass().getClassLoader();
      Method[] methods = cl.getClass().getMethods();
      for (Method method : methods) {
         if (method.getParameterCount() == 0 &&
                 method.getName().startsWith("get") &&
                 method.getReturnType() != void.class) {
            System.out.print(method.getName() + " : ");
            System.out.println(method.invoke(cl));
         }
      }

   }
}
