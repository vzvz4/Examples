package inheritance;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonAutoDetect
public class House {
  private List<Pet> list = new ArrayList<>();

  @JsonFormat(pattern = "dd-MM-yyyy")
  private Date date;

  public void add(Pet p) {
    list.add(p);
  }

  public House() {
  }

  public List<Pet> getList() {
    return list;
  }

  public void setList(List<Pet> list) {
    this.list = list;
  }
}
