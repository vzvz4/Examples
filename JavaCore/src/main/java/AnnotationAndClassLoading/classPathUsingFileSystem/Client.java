package AnnotationAndClassLoading.classPathUsingFileSystem;

import CovariantContravariant.Consumer;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) throws IOException {
        FileSystem fs = FileSystems.getFileSystem(URI.create("jrt:/"));

        Path objClassFilePath = fs.getPath("modules", "java.base", "java/util/");

        List<Path> list = Files.walk(objClassFilePath).collect(Collectors.toList());

//        list.forEach(System.out::println);
        walkFileTree(objClassFilePath).forEach(System.out::println);
        Consumer<String> consumer;
        cons(x -> System.out.println());
    }

    private static void cons(java.util.function.Consumer<String> cons) {
        cons.accept("");
    }

    private static List<String> walkFileTree(Path path) throws IOException {
        class Visitor implements FileVisitor<Path> {

            private List<String> result;

            public Visitor(List<String> result) {
                this.result = result;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
                result.add(path.getFileName().toString());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path path, IOException e) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path path, IOException e) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        }

        List<String> res = new ArrayList<>();
        Files.walkFileTree(path, new Visitor(res));
        return res;
    }
}
