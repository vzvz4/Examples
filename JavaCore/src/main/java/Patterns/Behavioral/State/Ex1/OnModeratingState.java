package Patterns.Behavioral.State.Ex1;

public class OnModeratingState extends DocumentState {

    public OnModeratingState(DocumentImpl document) {
        super(document);
    }

    @Override
    public void publish(User user) {
        if (user.isAdmin()) {
            GitHubGist.export(document);
        } else System.out.println("Permission denied");
    }

    @Override
    public void render(User user) {
        System.out.println(document.getText());
    }

}
