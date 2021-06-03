package Patterns.System.uow;

import Patterns.System.identitymap.IdentityMap;

import java.util.HashMap;
import java.util.Map;

public class FictionDataBase {
    private static final Map<String, DomainObject> dataBase = new HashMap<>();
    static {
        dataBase.put("1", new Product(1, 2, "Phone"));
        dataBase.put("4", new Product(4, 100, "Notebook"));
        IdentityMap.getInstance().put("1", new Product(1, 2, "Phone"));
    }

    public static DomainObject get(String id) {
        DomainObject object = dataBase.get(id);
        if (!IdentityMap.getInstance().contains(id)) {
            IdentityMap.getInstance().put(id, object);
        }
        return IdentityMap.getInstance().get(id);
    }

    public static void insert(String key, DomainObject value) throws Exception {
        if (!dataBase.containsKey(key)) {
            dataBase.put(key, value);
        } else throw  new Exception("Data Base Error!! Cant insert value: " + value);
    }

    public static DomainObject delete(String key) {
        return dataBase.remove(key);
    }

    public static DomainObject update(String key, DomainObject domainObject) {
        return dataBase.put(key, domainObject);
    }
}
