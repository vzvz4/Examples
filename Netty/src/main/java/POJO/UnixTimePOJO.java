package POJO;

import java.util.Date;

public class UnixTimePOJO {

  private final long value;

  public UnixTimePOJO() {
    this(System.currentTimeMillis() / 1000L + 2208988800L);
  }

  public UnixTimePOJO(long value) {
    this.value = value;
  }

  public long value() {
    return value;
  }

  @Override
  public String toString() {
    return new Date((value() - 2208988800L) * 1000L).toString();
  }
}


