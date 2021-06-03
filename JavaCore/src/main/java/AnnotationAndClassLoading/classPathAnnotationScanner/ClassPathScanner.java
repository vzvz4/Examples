package AnnotationAndClassLoading.classPathAnnotationScanner;

import AnnotationAndClassLoading.classPathAnnotationScanner.testPackage.TestAnnotation;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class ClassPathScanner {

    public static void main(String[] args) throws IOException {

        String packageName = TestAnnotation.class.getPackage().getName();
        String path = packageName.replace(".", "/");

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> list = new ArrayList<>();

        while (resources.hasMoreElements())
            list.add(new File(resources.nextElement().getPath()));

        Map<Class<?>, Annotation> an = list.stream()
                .flatMap(x -> (findAnno(x, packageName)).stream())
                .filter(x -> x.isAnnotationPresent(TestAnnotation.class))
                .collect(Collectors.toMap(y -> y, x -> x.getAnnotation(TestAnnotation.class)));
        an.forEach((key, value) -> System.out.println(key.getName() + " : " + value));
    }

    public static List<Class<?>> findAnno(File dir, String packageName) {
        if (!dir.exists())
            return Collections.emptyList();

        List<Class<?>> classes = new ArrayList<>();
        File[] files = dir.listFiles();
        try {
            for (File file : files) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return classes;
    }

    //--- есть библеотека Reflections которая все что написано выше делает за нас

//     <dependency>
//            <groupId>org.reflections</groupId>
//            <artifactId>reflections</artifactId>
//            <version>0.9.12</version>
//        </dependency>

//    private static void reflectionsScan() {
//        Reflections reflections = new Reflections(Server.class.getPackage().getName());
//        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Anno.class);
//
//        for (Class<?> cls : classes) {
//            Anno target = cls.getAnnotation(Anno.class);
//            System.out.println(target.name());
//        }
//    }


}
