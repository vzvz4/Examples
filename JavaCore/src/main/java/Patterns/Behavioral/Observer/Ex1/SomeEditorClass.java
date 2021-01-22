package Patterns.Behavioral.Observer.Ex1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SomeEditorClass {
    private static final EventManager eventManager = new EventManager();
    private File file;
    private boolean append;
    private String data = "";

    public SomeEditorClass() {
        eventManager.subscribe(new EmailAlertsListener());
    }

    public void openFile(String file) {
        this.file = new File(file);
        eventManager.notifySubs("File exists ? " + this.file.exists());
        if (this.file.exists()) {
            System.out.println("File opened: " + this.file.getAbsolutePath());
        }
    }

    public void editFile(String data, boolean append) {
        this.append = append;
        this.data = data;
        eventManager.notifySubs("Start to edit file: " + file.getAbsolutePath());
    }

    public void saveFile() {
        try(FileWriter fileWriter = new FileWriter(file, append)) {
            fileWriter.write(data);
            eventManager.notifySubs("file edited: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
