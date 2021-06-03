package Patterns.Behavioral.State.Ex1;

public abstract class DocumentState implements Document {
    protected DocumentImpl document;

    public DocumentState(DocumentImpl document) {
        this.document = document;
    }

    protected boolean checkPermissions(User user) {
        return user.isAdmin() || user.getName().equals(document.getAuthor().getName());
    }

}
