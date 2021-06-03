package AnnotationAndClassLoading.classLoader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/

public class Solution {
    public static void main(String[] args) {
        String path = Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() +
                Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data";
        System.out.println(path);
        Set<? extends Animal> allAnimals = getAllAnimals(path);
        System.out.println(allAnimals);
    }

    public static class Loader extends ClassLoader {

        protected Class<?> findClass(byte[] bytes) throws ClassNotFoundException {
            return defineClass(null, bytes, 0, bytes.length);
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] bytes = Files.readAllBytes(Paths.get(name));
                return defineClass(null, bytes, 0, bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return super.findClass(name);
        }

    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> result = new HashSet<>();
        Loader loader = new Loader();
        try {
            File[] files = new File(pathToAnimals).listFiles();
            for (File file : files) {
                Class<?> clazz = loader.findClass(file.getAbsolutePath());
                checkClass(clazz, result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static void checkClass(Class<?> clazz, Set<Animal> result) throws IllegalAccessException, InstantiationException {
        if (Animal.class.isAssignableFrom(clazz)) {
            Constructor<?>[] constructor = clazz.getConstructors();
            if (Arrays.stream(constructor).anyMatch(x -> x.getParameterCount() == 0)) {
                Animal animal = (Animal) clazz.newInstance();
                result.add(animal);
            }
        }
    }
}
