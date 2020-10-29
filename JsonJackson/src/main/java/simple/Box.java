package simple;

import com.fasterxml.jackson.annotation.*;


// Для сериализации в json нужны либо
// геттеры для полей либо аннотация @JsonProperty
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
//@JsonSubTypes({
//    @JsonSubTypes.Type(value = Case.class)
//})
//@JsonTypeName(value = "Box")
@JsonIgnoreProperties("color")
public class Box {

  private String color;

  @JsonProperty
  private int edgeLength;

  public Box(String color, int edgeLength) {
    this.color = color;
    this.edgeLength = edgeLength;
  }

  public String getColor() {
    return color;
  }
}
