package Polimorphism;

public class CreditApp {
    public static void main(String[] args) {
        CardAction dc1 = new CardAction();
        CardAction dc2 = new CreditCardAction();
        CreditCardAction cc = new CreditCardAction();
// CreditCardAction cca = new CardAction(); // ошибка компиляции
        dc1.doPayment(15.5); // метод класса CardAction
        dc2.doPayment(21.2); // полиморфный метод класса CreditCardAction
        cc.doPayment(7.0); // полиморфный метод класса CreditCardAction
        cc.checkCreditLimit(); // неполиморфный метод класса CreditCardAction
 //dc2.checkCreditLimit(); // ошибка компиляции – неполиморфный метод
        //((CreditCardAction)dc1).checkCreditLimit(); // ошибка времени выполнения
        ((CreditCardAction)dc2).checkCreditLimit(); // ок

        dc2.doPayment(22);
        System.out.println(dc1.getClass());
        System.out.println(dc2.getClass());
        System.out.println(cc.getClass());

    }
}
