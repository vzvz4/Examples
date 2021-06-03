package Patterns.System.identitymap;

import Patterns.System.Logger;
import Patterns.System.uow.DomainObject;

import java.text.DateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IdentityMap {
    private final Logger logger = Logger.getLogger(IdentityMap.class);
    private static IdentityMap identityMap;
    private Map<String, DomainObject> map;

    public static IdentityMap getInstance() {
        if (identityMap == null) identityMap = new IdentityMap();
        return identityMap;
    }

    private IdentityMap() {
        map = new ConcurrentHashMap<>();
    }

    public DomainObject put(String key, DomainObject val) {
        logger.log("Caching new value: " + val);
        return map.put(key, val);
    }

    public DomainObject get(String key) {
        return map.get(key);
    }

    public boolean contains(String key) {
        return map.containsKey(key);
    }

    public DomainObject remove(String key) {
        DomainObject object = map.remove(key);
        logger.log("Removing value from cache: " + object);
        return object;
    }

    public void printCurrentCache() {
        map.forEach((k, v) -> System.out.println(k + " : " + v));
    }

}
