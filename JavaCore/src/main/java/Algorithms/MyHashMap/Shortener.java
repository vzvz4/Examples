package Algorithms.MyHashMap;


import Algorithms.MyHashMap.strategy.StorageStrategy;

public class Shortener {
    private Long lastId;
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
        lastId = 0L;
    }

    public synchronized Long getId(String string) {
        if (storageStrategy.containsValue(string))
            return storageStrategy.getKey(string);
        else {
            lastId++;
            storageStrategy.put(lastId, string);
        }
        return lastId;
    }

    public synchronized String getString(Long id) {
        return storageStrategy.getValue(id);
    }
}
