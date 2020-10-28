package JavaNIO;

import java.io.IOException;
import java.nio.file.*;

public class NIO {
  public static void main(String[] args) throws IOException {
    Path path = Paths.get("./JavaCore/src",
        "JavaNIO", "folder");

    System.out.println(path.getRoot());
    System.out.println(path.getFileSystem());
    System.out.println(path.getParent());
    //проверяем существует ли такая директория и создаем ее если нет
    if (!Files.exists(path)) {
      Files.createDirectory(path);
    }
    //подписываем к пути имя файла и создаем его если не существует
    path = Paths.get(path.toString(), "1.txt");
    if (!Files.exists(path))
      Files.createFile(path);
    Files.write(path, "1234WWWW :))".getBytes());
    Files.lines(path).forEach(System.out::println);

    //StandardOpenOption - опции записи в файл
    Files.write(path,"New line hello world".getBytes(), StandardOpenOption.APPEND);
    Files.lines(path).forEach(System.out::println);

    //чтобы скопировать файл нужно установить политку записи
    System.out.println(Paths.get(path.getParent().toString()));
    Files.copy(Paths.get(path.getParent().toString(), "1.txt"),
                    path.getParent().getParent(),
        StandardCopyOption.REPLACE_EXISTING);

    System.out.println(Files.getOwner(path));
  }
}
