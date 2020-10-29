package inheritance;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class Client {

  public static void main(String[] args) throws IOException {

    System.out.println("-----------------");


    // ---- Write simple json
    Cat c = new Cat("Kitty", "Black");
    ObjectMapper mapper = new ObjectMapper();
    StringWriter sw = new StringWriter();
    mapper.writeValue(sw, c);

    System.out.println(sw);

    System.out.println("-----------------");


//    // ---- Read simple json
//    String jsonString = "{\"name\":\"Murka\",\"color\":\"Purple\",\"cats\":[{\"name\":\"Timka\"},{\"name\":\"Killer\"}]}";;
//    ObjectMapper mapper1 = new ObjectMapper();
//    StringReader reader = new StringReader(jsonString);
//    inheritance.Cat c1 = mapper1.readValue(reader, inheritance.Cat.class);
//    System.out.println(c1);
//
    System.out.println("-----------------");

    // ---- Write inherited json
    Cat c2 = new Cat("Caz", "Blue");
    Dog d = new Dog("Doz", 5);
    List<Pet> pets = new ArrayList<>();
    pets.add(c2);
    pets.add(d);
    StringWriter sw2 = new StringWriter();
    ObjectMapper mapper2 = new ObjectMapper();
    mapper2.writeValue(sw2, pets);
    System.out.println(sw2);

    System.out.println("-----------------");

    House h = new House();
    StringWriter sw3 = new StringWriter();
    h.add(c2);
    h.add(d);
    ObjectMapper mapper3 = new ObjectMapper();
    mapper3.writeValue(sw3, h);
    System.out.println(sw3);

  }
}
