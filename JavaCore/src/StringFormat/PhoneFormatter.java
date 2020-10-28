package StringFormat;

public class PhoneFormatter {
  public static void main(String[] args) {
    String s = "Ivanov, Ivan";
    String str  = "98(22)-12-31213";
    str = str.replaceAll("\\D+","");
    System.out.println(str);
    System.out.println(s.substring(0, s.indexOf(" ") - 1));
    System.out.println(s.substring(s.indexOf(" ") + 1));
  }
}
