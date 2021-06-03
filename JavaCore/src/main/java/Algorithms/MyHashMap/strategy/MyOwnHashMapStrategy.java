package Algorithms.MyHashMap.strategy;

import java.util.Objects;

public class MyOwnHashMapStrategy implements StorageStrategy {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int threshold;
    private float loadFactor;

    private int size;

    private Entry[] table;

    public MyOwnHashMapStrategy() {
        table = new Entry[DEFAULT_INITIAL_CAPACITY];
        threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        loadFactor = DEFAULT_LOAD_FACTOR;
    }

    private int hash(Long k) {
        return Objects.hashCode(k);
    }

    private int indexFor(int hash, int length) {
        return length - 1 & hash;
    }

    private void resize(int newCapacity) {
        threshold = (int) (newCapacity * loadFactor);
        Entry[] entries = new Entry[newCapacity];
        transfer(entries);
    }

    private void transfer(Entry[] newTable) {
        size = 0;
        Entry[] old = table;
        table = newTable;
        for (Entry entry : old) {
            Entry copy = entry;
            while (copy != null) {
                put(copy.key, copy.value);
                copy = copy.next;
            }
        }
    }

    private void addEntry(int hash, Long key, String value, int bucketIndex) {
        Entry bucket = table[bucketIndex];
        Entry entry = new Entry(hash, key, value, null);

        Entry parent = null;
        Entry copy = bucket;

        boolean replacing = false;

        while (copy != null) {
            if (copy.hash == hash && copy.key.equals(key)) {
                entry.next = copy.next;
                replacing = true;
                break;
            }
            parent = copy;
            copy = copy.next;
        }

        if (parent != null)
            parent.next = entry;

        if (entry.next == null && !replacing) size++;
    }

    private void createEntry(int hash, Long key, String value, int bucketIndex) {
        size++;
        table[bucketIndex] = new Entry(hash, key, value, null);
    }

    @Override
    public boolean containsKey(Long key) {
        int index = indexFor(hash(key), table.length);
        return table[index] != null;
    }

    @Override
    public boolean containsValue(String value) {
        for (Entry entry : table) {
            if (entry != null) {
                Entry copy = entry;
                while (copy != null) {
                    if (copy.value.equals(value))
                        return true;
                    copy = copy.next;
                }
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        if (key == null) {
            createEntry(0, null, value, 0);
        } else {
            int hash = hash(key);
            int ind = indexFor(hash, table.length);
            Entry bucket = table[ind];
            if (bucket == null)
                createEntry(hash, key, value, ind);
            else {
                addEntry(hash, key, value, ind);
            }
        }
        if (size >= threshold) resize(table.length * 2);
    }

    private Entry getEntry(Long key) {
        int hash = hash(key);
        Entry copy = table[indexFor(hash, table.length)];
        while (copy != null) {
            if (copy.hash == hash) {
                break;
            }
            copy = copy.next;
        }
        return copy;
    }

    @Override
    public Long getKey(String value) {
        for (Entry entry : table) {
            if (entry != null) {
                Entry res = entry;
                while (!res.value.equals(value)) {
                    res = res.next;
                }
                return res.key;
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        return getEntry(key).value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (Entry entry : table) {
            if (entry != null) {
                Entry copy = entry;
                while (true) {
                    sb.append(copy.value);
                    sb.append(", ");
                    if (copy.next == null) {
                        break;
                    }
                    copy = copy.next;
                }
            }
        }
        int lastInd = sb.lastIndexOf(",");
        sb.append("]").replace(lastInd, lastInd + 2, "");
        return sb.toString();
    }

    public int getSize() {
        return size;
    }
}
