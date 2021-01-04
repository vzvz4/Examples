package GarbageCollector;

import java.lang.ref.WeakReference;

public class WeakReferences {
    public static void main(String[] args) {
        Cat cat = new Cat("Black");
        WeakReference<Cat> weakReference = new WeakReference<>(cat);

        //теперь на объект ссылается только слабая ссылка catRef.
        cat = null;

        //теперь на объект ссылается еще и обычная переменная cat
        cat = weakReference.get();

        // Если на объект не осталось обычных ссылок и мягких ссылок,
        // а только слабые ссылки, то этот объект является живым,
        // но он будет уничтожен при ближайшей сборке мусора.
        // Объект, который удерживает от смерти только SoftReference
        // может пережить сколько угодно сборок мусора и скорее всего, будет уничтожен при нехватке программе памяти.
        // Объект, который удерживает от смерти только WeakReference не переживает ближайшей сборки мусора.
        // Но пока она не произошла, его можно получить, вызвав метод get() у WeakReference и вызвать его методы или сделать что-нибудь еще.
    }
}
