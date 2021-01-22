package Patterns.Behavioral.Observer.Ex1;

public class Client {
    public static void main(String[] args) {
        SomeEditorClass editor = new SomeEditorClass();
        editor.openFile("C:\\ARCH\\Examples\\JavaCore\\src\\main\\java\\Patterns\\Behavioral\\Observer\\Ex1\\file.txt");
        editor.editFile("Hello wordl", true);
        editor.saveFile();
    }
}
