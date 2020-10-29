package simple;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.List;

//@JsonTypeName(value = "Case")
public class Case extends Box {

  @JsonProperty
  private String material;

  @JsonProperty
  private List<Box> boxList;

  public Case(String color, int edgeLength, String material) {
    super(color, edgeLength);
    this.material = material;
    boxList = new ArrayList<>();
  }

  public void add(Box b) {
    boxList.add(b);
  }
}
