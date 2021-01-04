package org.example;

import java.util.Arrays;
import java.util.HashMap;

public class Reader {
   private interface P {
      int getP();
   }

   private static class Person implements P {
      private String name;

      public Person(String name) {
         this.name = name;
      }

      @Override
      public int getP() {
         return 20;
      }
   }

   public static void get(Person p) {
      System.out.println(p.getP());
   }

   public static void main(String[] args) {
      Obj ob1 = new Obj(1, 1, 2);
      Obj ob2 = new Obj(-3,-3, 4);
      System.out.println(ob1.isIntersect(ob2));
      System.out.println(ob1.evalDistance(ob2));
   }

}
