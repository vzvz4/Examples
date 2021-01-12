package org.example;

import java.util.ArrayList;
import java.util.List;

public class Reader {

   static class A {}
   static class B extends A {}
   static class C extends B {}
   static class D extends A {}

   // Producer
   static void add(List<? super B> list, B a) {
      list.add(a);
      for (Object o : list) {
         System.out.println(o);
      }
   }

   public static void main(String[] args) {
      List<B> list = new ArrayList<>();
      list.add(new C());
      add(list, new C());
   }
}
