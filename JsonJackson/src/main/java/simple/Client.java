package simple;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.Map;

public class Client {
  public static void main(String[] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    Box b = new Box("Green", 5);
    StringWriter sw = new StringWriter();
    mapper.writeValue(sw, b);
    System.out.println(sw.toString());

    System.out.println("--------------------------");
    Box c = new Case("Brown", 10, "Cardboard");
    StringWriter sw2 = new StringWriter();
    mapper.writeValue(sw2, c);
    System.out.println(sw2.toString());

    System.out.println("--------------------------");
    StringWriter sw3 = new StringWriter();
    Box bb = new Case("Purple", 11, "Metal");
    Case cc = new Case("Green", 15, "Plastic");
    Case cc1 = new Case("White", 3, "Wood");
    ((Case) bb).add(cc);
    ((Case) bb).add(cc1);
    ((Case) bb).add(new Box("Yellow", 15));
    ((Case) bb).add(new Garage("Yellow", 15));
    mapper.writeValue(sw3, bb);
    System.out.println(sw3);

    System.out.println("--------------------------");

  }
}
