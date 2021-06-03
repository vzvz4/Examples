package Patterns.System.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Глобальный объект, который используется другими объектами для поиска общих объектов или служб
public class Registry {

    private static Registry instance;

    private final Map<String, Reference> registry = new ConcurrentHashMap<>();

    public static synchronized Registry getInstance() {
        if (instance == null) {
            instance = new Registry();
        }
        return instance;
    }

    public Reference getReference(final String name) {
        final Reference result;
        if (isRegistered(name)) {
            result = registry.get(name);
        } else {
            result = new Reference(name);
            registry.put(name, result);
        }
        return result;
    }

    private boolean isRegistered(final String name) {
        return registry.containsKey(name);
    }

    public void register(final PlanningObject object) {
        final Reference reference = getReference(
                object.getName());
        if (!reference.hasObject()
                || reference.getObject() != object) {
            reference.setObject(object);
        }
    }

    public void unregister(final PlanningObject object) {
        if (isRegistered(object.getName())) {
            final Reference reference = getReference(
                    object.getName());
            if (reference.hasObject()) {
                reference.setObject(null);
            }
        }
    }

}
