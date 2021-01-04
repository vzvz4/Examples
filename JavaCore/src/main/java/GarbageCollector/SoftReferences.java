package GarbageCollector;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class SoftReferences {
    public static void main(String[] args) {
        Cat cat = new Cat("Green");
        SoftReference<Cat> softReference = new SoftReference<>(cat);
    }


}
