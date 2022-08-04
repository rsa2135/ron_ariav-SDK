package utils;

import java.util.LinkedList;
import java.util.List;

public class Paginator {
  private final Integer limit;
  private final Integer page;
  private final Integer offset;

  public Paginator() {
    this.limit = null;
    this.page = null;
    this.offset = null;
  }

  public Paginator(PaginatorBuilder paginatorBuilder) {
    this.limit = paginatorBuilder.limit;
    this.page = paginatorBuilder.page;
    this.offset = paginatorBuilder.offset;
  }

  public static class PaginatorBuilder {

    private Integer limit;
    private Integer page;
    private Integer offset;

    public PaginatorBuilder limit(int limit) {
      this.limit = limit;
      return this;
    }

    public PaginatorBuilder page(int page) {
      this.page = page;
      return this;
    }

    public PaginatorBuilder offset(int offset) {
      this.offset = offset;
      return this;
    }

    public Paginator build() {
      return new Paginator(this);
    }
  }

  public String getQuery() {
    List<String> query = new LinkedList<>();
    if (this.limit != null) {
      query.add("limit=" + this.limit);
    }

    if (this.page != null) {
      query.add("page=" + this.page);
    }

    if (this.offset != null) {
      query.add("offset=" + this.offset);
    }
    return String.join("&", query);
  }
}
