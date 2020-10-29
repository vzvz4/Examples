import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

  @Test
  public void testSum() {
    Calculator calculator = new Calculator();
    Assert.assertEquals(7, calculator.sum(3, 4));
  }

}
