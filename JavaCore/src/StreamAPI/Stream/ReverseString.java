package StreamAPI.Stream;

public class ReverseString {
  public static void main(String[] args) {
    String str = "Java";
    String reversed = str.chars()
        .mapToObj(c -> (char)c)
        .reduce("", (s,c) -> c+s, (s1,s2) -> s2+s1);

    //or
    String reversed2 = str.chars()
        .collect(StringBuilder::new, (b,c) -> b.insert(0,(char)c), (b1,b2) -> b1.insert(0, b2))
        .toString();
  }
}
