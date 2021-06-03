package Patterns.System.registry;

import java.util.HashSet;
import java.util.Set;

public class UserStoryImpl extends PlanningObjectImpl implements UserStory {

    private final Set<Reference> dependsOn = new HashSet<>();

    public UserStoryImpl(final String name) {
        super(name);
    }

    public void addDependsOn(final String userStoryName) {
        dependsOn.add(Registry.getInstance().getReference(
                userStoryName));
    }

    public Set<UserStory> getDependsOn() {
        final Set<UserStory> result = new HashSet<>();
        for (final Reference reference : dependsOn) {
            if (reference.hasObject()) {
                result.add((UserStory) reference.getObject());
            }
        }
        return result;
    }

    // ...

}
