package FinalizeEx;

import java.util.Random;

public class Final {

    //от класса нельзя унаследоваться
    static final class Amphibian {

        //константа времени компиляции
        static final int INT_1 = new Random().nextInt(20);

        //не может быть константой времни компиляции
        final int int1 = new Random().nextInt(20);

        //нельзя изменить ссылку но можно изменить объект
        final static Integer o = new Integer(3);

        //нельзя поменять значение
        final static Integer b = 3;

        public static void main(String[] args) {

            Amphibian am = new Amphibian();
            System.out.println(am.int1);
            System.out.println(Amphibian.INT_1);
            Amphibian am2 = new Amphibian();
            System.out.println(am2.int1);
            System.out.println(Amphibian.INT_1);
        }

        //метод нельзя переопределить
        public final void meth(final int a) {
            //a = 5;   <-- Ошибка!
            System.out.println(a);
        }
    }
}
