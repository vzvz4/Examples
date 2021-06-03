package Patterns.Behavioral.State.Ex1;

import java.util.Date;

public class Client {
    public static void main(String[] args) {
        User author = new User(false, "Igor");
        User admin = new User(true, "Adam");

        Document gitHubProject = new DocumentImpl(new Author(author), new Date(),
                "POJO e.g Plain Old Java Object");
        admin.publishDocument(gitHubProject);

        author.renderDocument(gitHubProject);
        author.publishDocument(gitHubProject);

        admin.publishDocument(gitHubProject);
    }
}
