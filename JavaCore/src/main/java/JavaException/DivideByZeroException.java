package JavaException;

public class DivideByZeroException extends ArithmeticException {
    public DivideByZeroException() {
        super("Dividing by zero...");
    }
}
