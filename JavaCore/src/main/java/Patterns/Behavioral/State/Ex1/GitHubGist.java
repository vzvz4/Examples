package Patterns.Behavioral.State.Ex1;

import java.text.DateFormat;

public class GitHubGist {
    public static void export(DocumentImpl document) {
        System.out.println("------Git hub IO-------");
        System.out.printf("Author: %s, Date %s\n", document.getAuthor().getName(),
                DateFormat.getDateInstance().format(document.getDate()));
        System.out.println("-----------------------");
        System.out.println(document.getText());
    }
}
