package Patterns.System.uow;

import Patterns.System.Logger;
import Patterns.System.identitymap.IdentityMap;

import java.util.ArrayList;
import java.util.List;

public class UnitOfWork {
    private static final ThreadLocal<UnitOfWork> current = new ThreadLocal<>();
    private final Logger logger = Logger.getLogger(UnitOfWork.class);

    private final List<DomainObject> newObjects = new ArrayList<>();
    private final List<DomainObject> dirtyObjects = new ArrayList<>();
    private final List<DomainObject> removedObjects = new ArrayList<>();

    private UnitOfWork() {}

    public void registerNew(DomainObject object) {
        logger.log("Register new object: " + object);
        newObjects.add(object);
    }

    public void registerDirty(DomainObject object) {
        logger.log("Register dirty object: " + object);
        dirtyObjects.add(object);
    }

    public void registerRemoved(DomainObject obj) {
        logger.log("Register removed object: " + obj);
        removedObjects.add(obj);
    }

    public void registerClean(DomainObject obj) {

    }

    public void commit() {
        insertNew();
        updateDirty();
        deleteRemoved();
    }

    private void deleteRemoved() {
        for (DomainObject object : removedObjects) {
            FictionDataBase.delete(object.getKey());
            IdentityMap.getInstance().remove(object.getKey());
            System.out.println("Deleting " + object.toString());
        }
    }

    private void updateDirty() {
        for (DomainObject object : dirtyObjects) {
            FictionDataBase.update(object.getKey(), object);
            System.out.println("Updating " + object.toString());
        }
    }

    private void insertNew() {
        for (DomainObject object : newObjects) {
            if (!IdentityMap.getInstance().contains(object.getKey())) {
                try {
                    FictionDataBase.insert(object.getKey(), object);
                } catch (Exception e) {
                    logger.log("Error!");
                    e.printStackTrace();
                }
                IdentityMap.getInstance().put(object.getKey(), object);
                System.out.println("Adding new " + object.toString());
            } else logger.log("Object present in cache, cant insert new: " + object);
        }
    }

    public static void newCurrent() {
        setCurrent(new UnitOfWork());
    }

    public static void setCurrent(UnitOfWork unitOfWork) {
        current.set(unitOfWork);
    }

    public static UnitOfWork getCurrent() {
        return (UnitOfWork) current.get();
    }

}
