package utils;

import static java.util.stream.Collectors.*;

import java.util.LinkedList;
import java.util.List;

public class Options {
  Paginator paginator;
  Sorter sorter;
  Filter filter;

  public Options() {
    this.paginator = null;
    this.sorter = null;
    this.filter = null;
  }

  public Options(OptionsBuilder optionsBuilder) {
    this.paginator = optionsBuilder.paginator;
    this.sorter = optionsBuilder.sorter;
    this.filter = optionsBuilder.filter;
  }

  public static class OptionsBuilder {
    Paginator paginator;
    Sorter sorter;
    Filter filter;

    public OptionsBuilder withPaginator(Paginator paginator) {
      this.paginator = paginator;
      return this;
    }

    public OptionsBuilder withSorting(Sorter sorter) {
      this.sorter = sorter;
      return this;
    }

    public OptionsBuilder withFiltering(Filter filter) {
      this.filter = filter;
      return this;
    }

    public Options build() {
      return new Options(this);
    }
  }

  public String buildQuery() {
    List<String> query = new LinkedList<>();
    if (this.paginator != null) query.add(this.paginator.getQuery());
    if (this.sorter != null) {
      query.add(this.sorter.getQuery());
    }
    if (this.filter != null) query.add(this.filter.getQuery());
    final String fullQuery = query.stream().filter(s -> !s.equals("")).collect(joining("&"));
    return query.size() > 0 ? "?" + fullQuery : "";
  }
}
