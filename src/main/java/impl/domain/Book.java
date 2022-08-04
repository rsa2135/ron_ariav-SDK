package impl.domain;

public class Book {
  String id;
  String name;

  public String getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    return "Book{" + "id='" + id + '\'' + ", name='" + name + '\'' + '}';
  }
}
