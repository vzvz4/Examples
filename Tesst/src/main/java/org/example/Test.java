package org.example;

import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static class TestClass<T> {

        private T value1;
        public T value2;

        public void printValues() {
            System.out.println(value1);
            System.out.println(value2);
        }

        public static <T> TestClass<T> createAndAdd2Values(Object o1, Object o2) {
            TestClass<T> result = new TestClass<>();
            result.value1 = (T) o1;
            result.value2 = (T) o2;
            return result;
        }

        public static void main(String[] args) {
            Double d = 22.111;
            String s = "Test String";
            TestClass<Integer> test = createAndAdd2Values(d, s);

            test.printValues();
            Class<?> clazz = test.value1.getClass();
            System.out.println(clazz);
            System.out.println(test.value1.getClass());
            Object x[] = new String[3];
            x[0] = 222;

        }
    }

}
