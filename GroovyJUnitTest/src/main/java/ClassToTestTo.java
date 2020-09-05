import java.util.List;
public class ClassToTestTo {

  public String concat(List<String> strings,
                       String separator) {
    StringBuilder sb = new StringBuilder();
    String sep = "";
    for(String s: strings) {
      sb.append(sep).append(s);
      sep = separator;
    }
    return sb.toString();
  }

}