package simple;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@JsonIgnoreType
public class Garage extends Box {

  public Garage(String color, int edgeLength) {
    super(color, edgeLength);
  }
}
