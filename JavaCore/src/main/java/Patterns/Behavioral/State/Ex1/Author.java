package Patterns.Behavioral.State.Ex1;

public class Author {
    private boolean admin;
    private String name;

    public Author(User user) {
        this.admin = user.isAdmin();
        this.name = user.getName();
    }

    public boolean isAdmin() {
        return admin;
    }

    public String getName() {
        return name;
    }
}
