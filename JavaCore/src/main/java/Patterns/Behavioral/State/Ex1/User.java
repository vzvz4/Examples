package Patterns.Behavioral.State.Ex1;

public class User {
    private boolean admin;
    private String name;

    public User(boolean admin, String name) {
        this.admin = admin;
        this.name = name;
    }

    public void renderDocument(Document document) {
        document.render(this);
    }

    public void publishDocument(Document document) {
        document.publish(this);
    }

    public boolean isAdmin() {
        return admin;
    }

    public String getName() {
        return name;
    }
}
