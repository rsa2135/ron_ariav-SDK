package utils;

import static com.google.common.truth.Truth.assertThat;
import static utils.Sorter.Direction.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class OptionsTest {

  @Nested
  @DisplayName("buildQuery")
  class GetQuery {

    @Test
    @DisplayName("returns empty string when no values are provided")
    void returnsCorrectStringWhenNoValues() {
      final Options options = new Options();
      assertThat(options.buildQuery()).isEqualTo("");
    }

    @Test
    @DisplayName("returns the query when one values is provided")
    void returnsCorrectStringWhenOneValue() {
      final Options options =
          new Options.OptionsBuilder()
              .withPaginator(new Paginator.PaginatorBuilder().limit(10).build())
              .build();
      assertThat(options.buildQuery()).isEqualTo("?limit=10");
    }

    @Test
    @DisplayName("returns the correct query when multiple values are provided")
    void returnsCorrectStringWhenMultipleValues() {
      final Options options =
          new Options.OptionsBuilder()
              .withPaginator(new Paginator.PaginatorBuilder().limit(10).offset(10).build())
              .withSorting(new Sorter("name", ASC))
              .withFiltering(new Filter("name=/foot/i"))
              .build();
      assertThat(options.buildQuery()).isEqualTo("?limit=10&offset=10&sort=name:asc&name=/foot/i");
    }
  }
}
