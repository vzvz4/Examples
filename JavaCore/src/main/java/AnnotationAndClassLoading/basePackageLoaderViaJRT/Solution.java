package AnnotationAndClassLoading.basePackageLoaderViaJRT;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        FileSystem fs = FileSystems.getFileSystem(URI.create("jrt:/"));
        Path objClassFilePath = fs.getPath("modules", "java.base", "java/util/concurrent/");
        List<Class> target = new ArrayList<>();
        try {
            Path dir = Files.walk(objClassFilePath).findFirst().get();
            List<Path> list = new ArrayList<>();
            Files.walkFileTree(dir, new ConcurrentPackageVisitor(list));
            for (Path path : list) {
                if (!Files.isDirectory(path)) {
                    String className = path.getFileName().toString();
                    String targetName = "java.util.concurrent." + className.substring(0, className.indexOf("."));
                    Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass(targetName);
                    Class<?> targetClass = BlockingQueue.class;
                    if (targetClass.isAssignableFrom(clazz)) {
                        target.add(clazz);
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static class ConcurrentPackageVisitor extends SimpleFileVisitor<Path> {
        private List<Path> list;

        public ConcurrentPackageVisitor(List<Path> list) {
            this.list = list;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            if (path.toString().equals("modules/java.base/java/util/concurrent"))
                return super.preVisitDirectory(path, basicFileAttributes);
            else return FileVisitResult.TERMINATE;
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            list.add(path);
            return FileVisitResult.CONTINUE;
        }
    }
}
