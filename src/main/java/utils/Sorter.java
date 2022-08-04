package utils;

public class Sorter {
  private final String field;
  private final Direction direction;

  public Sorter() {
    this.field = null;
    this.direction = null;
  }

  public Sorter(String field, Direction direction) {
    this.field = field;
    this.direction = direction;
  }

  public String getQuery() {
    if (this.field != null && this.direction != null)
      return "sort=" + this.field + ":" + this.direction.toString().toLowerCase();
    else return "";
  }

  public enum Direction {
    ASC,
    DESC
  }
}
