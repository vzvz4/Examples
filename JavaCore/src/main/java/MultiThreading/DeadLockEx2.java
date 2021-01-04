package MultiThreading;

public class DeadLockEx2 {

//    "Thread-1":
//    waiting to lock monitor 0x000000000330c0d8 (object 0x00000000d5e16808, a Pck.Pc.Ext$Friends),
//    which is held by "Thread-0"
//            "Thread-0":
//    waiting to lock monitor 0x000000001b806038 (object 0x00000000d5e16848, a Pck.Pc.Ext$Friends),
//    which is held by "Thread-1"

    static class Friend {
        private final String name;
        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s" + "  has bowed to me!%n", this.name, bower.getName());
            bower.bowBack(this);
        }

        //Потоки зависают здесь
        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s"
                            + " has bowed back to me!%n",
                    this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");
        new Thread(() -> alphonse.bow(gaston)).start();
        new Thread(() -> gaston.bow(alphonse)).start();
    }
}
