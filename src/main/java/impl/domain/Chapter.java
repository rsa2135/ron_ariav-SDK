package impl.domain;

import com.google.gson.annotations.SerializedName;

public class Chapter {
  String id;

  @SerializedName("chapterName")
  String name;

  @SerializedName("book")
  String bookId;

  public Chapter(String id, String name, String bookId) {
    this.id = id;
    this.name = name;
    this.bookId = bookId;
  }

  public String getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getBookId() {
    return this.bookId;
  }

  @Override
  public String toString() {
    return "Chapter{"
        + "id='"
        + id
        + '\''
        + ", name='"
        + name
        + '\''
        + ", bookId='"
        + bookId
        + '\''
        + '}';
  }
}
