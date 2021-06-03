package AnnotationAndClassLoading.defineAllAvaliableRuntimeLibraries;

//import jdk.internal.loader.URLClassPath;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

import java.net.URL;
import java.net.URLClassLoader;

public class Main {
    public static void main(String[] args) throws Exception {
        //defineRuntimeInvolvedPackagesViaContextClassLoader();

        // Через системный загрузчик
        defineViaURLClassPath();
    }

    public static void defineViaURLClassPath() throws NoSuchFieldException, IllegalAccessException, IOException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Field filed = loader.getClass().getDeclaredField("ucp");
        // for this add VM args --add-opens java.base/jdk.internal.loader=ALL-UNNAMED
        filed.setAccessible(true);
//        jdk.internal.loader.URLClassPath ucp = (URLClassPath) filed.get(loader);
//        for(URL url : ucp.getURLs()) {
//            Path path = Paths.get(url.getFile().substring(1));
//            Files.isDirectory(path);
//            if (path.toString().matches(".+\\.jar$")) {
//                System.out.println(path.getFileName());
//                defineAllPackagesInJar(path.toString().replaceAll("%20", " "));
//            }
//        }
    }

    public static void defineViaURLClassLoader() throws IOException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        URL[] urls = ((URLClassLoader) loader).getURLs();
        for (URL url : urls) {
            defineAllPackagesInJar(url.getFile());
        }
    }

    private static void defineAllPackagesInJar(String file) throws IOException {
        JarFile jar = new JarFile(file);
        jar.stream()
                .map(ZipEntry::getName)
                .filter(name -> name.endsWith(".class"))
                .map(name -> name
                        .substring(0, name.lastIndexOf('/'))
                        .replace('/', '.')
                )
                .distinct()
                .forEach(System.out::println);
    }

    public static void defineRuntimeInvolvedPackagesViaContextClassLoader() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        ClassLoader ctxLoader = Thread.currentThread().getContextClassLoader();
//        Class base = ctxLoader.getClass();
//        while (base.getSuperclass() != null && !base.getSuperclass().equals(Object.class)) {
//            base = base.getSuperclass();
//        }
//        Method method = base.getDeclaredMethod("getPackages");
//        method.setAccessible(true);
//        Package[] packages = (Package[]) method.invoke(ctxLoader);
//        for (Package pac : packages) {
//            System.out.println(pac.getName());
//        }
    }
}
