package InnerNestedLocalClassesEx.InnerClassesExample;

//Вложенные классы - Nested (static)

//Внутренние классы - Inner (non static)

//Локальные внутренние классы (вложены в область видимости метода);

//Внутренний класс (иннер) скрыто харнит ссылку на объект внешнего класса, создать объект
// иннер класса можно только через объект внешнего класса.

//Для создания объекта вложенного класса (нестед) не нужен объект внешнего класса

public class OtherExample {
    private static int a = 1;
    private int b = 2;

    public void m() {
        NestedClass n = new NestedClass();
        InnerClass i = new InnerClass();

        i.iA = 5;
        i.iB = 6;
    }


    public static void main(String[] args) {
        NestedClass n = new NestedClass();
        n.nB = 3;
        n.nM();
        //способ созания объекта иннер (нестатического) класса
        OtherExample.Inn in = new OtherExample().new Inn();
        //способ создания объекта нестед (статического) класса
        OtherExample.Nes nes = new OtherExample.Nes();
        //InnerClass i = new InnerClass(); - ошибка, нельзя обратиться из статического метода

    }

    public final class InnerClass implements Runnable {
        //нельзя создать static поля
        private int iA = 1;
        public int iB = 2;

        public void iM() {
            a = 4;
            b = 5;
        }

        @Override
        public void run() {

        }
    }

    public static final class NestedClass implements Runnable{
        private static int sA = 1;
        private int nB = 2;

        public static void nSM() {

        }

        public void nM() {
            a = 3;
            //b = 4; - ошибка, нельзя обратиться к нестатической переменной
        }

        @Override
        public void run() {

        }
    }

    public class Inn2 extends Inn {
        //...{}
    }

    public class Inn implements Runnable{
        @Override
        public void run() {
            //...{}
        }
    }

    static class Nes extends Nes2{
        //...{}
    }

    static class Nes2 {
        //...{}
    }


}
