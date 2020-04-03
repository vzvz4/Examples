package InnerClassesExample.Car;

public class OtherExample {
    private static int a = 1;
    private int b = 2;

    private void m() {
        NestedClass n = new NestedClass();
        InnerClass i = new InnerClass();
        i.iA = 5;
        i.iB = 6;
    }

    public static void main(String[] args) {
        NestedClass n = new NestedClass();
        n.sB = 3;
        n.sM();
        //InnerClass i = new InnerClass(); - ошибка, нельзя обратиться из статического метода

    }

    private static final class NestedClass implements Runnable{
        private static int sA = 1;
        public int sB = 2;

        private void sM() {
            a = 3;
            //b = 4; - ошибка, нельзя обратиться к нестатической переменной
        }

        @Override
        public void run() {

        }
    }

    private final class InnerClass implements Runnable {
        //нельзя создать static поля
        private int iA = 1;
        public int iB = 2;

        private void iM() {
            a = 4;
            b = 5;
        }

        @Override
        public void run() {

        }
    }
}
