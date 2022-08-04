package utils;

public class Filter {
  String filterQuery;

  public Filter() {
    this.filterQuery = null;
  }

  public Filter(String filterQuery) {
    this.filterQuery = filterQuery;
  }

  public String getQuery() {
    return filterQuery == null ? "" : filterQuery;
  }
}
