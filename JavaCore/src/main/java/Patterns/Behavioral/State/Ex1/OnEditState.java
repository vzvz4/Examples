package Patterns.Behavioral.State.Ex1;

public class OnEditState extends DocumentState {

    public OnEditState(DocumentImpl document) {
        super(document);
    }

    @Override
    public void publish(User user) {
        System.out.println("Document is now editing!");
        if (user.getName().equals(document.getAuthor().getName())) {
            document.changeState(new OnModeratingState(document));
        }
    }

    @Override
    public void render(User user) {
        if (checkPermissions(user)) {
            System.out.println(document.getText());
        }
    }
}
