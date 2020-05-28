package Test;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Reflex {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Some someReflexClass = new SomeReflexClass();
        Method[] m2 = someReflexClass.getClass().getDeclaredMethods();
        Arrays.stream(m2)
                .filter(m -> m.getModifiers() == Modifier.PUBLIC)
                .filter(m -> m.getParameterTypes().length == 0)
                .forEach(m -> {
                    try {
                        m.invoke(someReflexClass);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
//                .forEach(m->System.out.println(m.getName()));

        //Arrays.stream(m2).filter(Method::isVarArgs).forEach(System.out::println);
//                someReflexClass.getClass().getMethod("method");
//        m.invoke(someReflexClass);
    }
}
