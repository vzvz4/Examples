package ReferencesSoftWeakPhantom;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;

public class PhantomRef {

    public static void main(String[] args) {
        ReferenceQueue<Integer> queue = new ReferenceQueue<>();

        //список призрачных ссылок
        ArrayList<PhantomInteger> list = new ArrayList<>();

        //создаем 10 объектов и добавляем их в список через призрачные ссылки
        for ( int i = 0; i < 10; i++) {
            Integer x = new Integer(i);
            list.add(new PhantomInteger (x, queue));
        }

        Thread referenceThread = new Thread(() -> {
            while (true) {
                try {
                    //получаем новый объект из очереди, если объекта нет - ждем!
                    PhantomInteger ref = (PhantomInteger)queue.remove
                            ();
                    //вызвваем у него метод close
                    ref.close();
                    ref.clear();
                }
                catch (Exception ex) {
                    // пишем в лог ошибки
                }
            }
        });

        //запускаем поток в служебном режиме.
        referenceThread.setDaemon(true);
        referenceThread.start();
    }

    public static class PhantomInteger extends PhantomReference<Integer> {

        public PhantomInteger(Integer referent, ReferenceQueue<? super Integer> q) {
            super(referent, q);
        }

        private void close() {
            System.out.println("Bad Integer totally destroyed!");
        }
    }
}
