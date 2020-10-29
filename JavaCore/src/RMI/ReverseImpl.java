package RMI;

public class ReverseImpl implements Reverse {

  @Override
  public String revers(String str) {
    return new StringBuilder(str).reverse().toString();
  }
}
