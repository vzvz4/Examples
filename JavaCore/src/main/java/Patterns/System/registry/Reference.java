package Patterns.System.registry;

public class Reference {

    private PlanningObject object;
    private final String name;

    public Reference(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean hasObject() {
        return object != null;
    }

    public PlanningObject getObject() {
        return object;
    }

    public void setObject(final PlanningObject object) {
        this.object = object;
    }

}
