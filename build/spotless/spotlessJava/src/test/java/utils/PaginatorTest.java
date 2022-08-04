package utils;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class PaginatorTest {

  @Nested
  @DisplayName("getQuery")
  class GetQuery {

    @Test
    @DisplayName("returns empty string when no values are provided")
    void returnsCorrectStringWhenNoValues() {
      final Paginator paginator = new Paginator();
      assertThat(paginator.getQuery()).isEqualTo("");
    }

    @Test
    @DisplayName("returns the correct query when one values is provided")
    void returnsCorrectStringWhenOneValue() {
      final Paginator paginator = new Paginator.PaginatorBuilder().limit(10).build();
      assertThat(paginator.getQuery()).isEqualTo("limit=10");
    }

    @Test
    @DisplayName("returns the correct query when multiple values are provided")
    void returnsCorrectStringWhenMultipleValues() {
      final Paginator paginator = new Paginator.PaginatorBuilder().limit(10).offset(10).build();
      assertThat(paginator.getQuery()).isEqualTo("limit=10&offset=10");
    }
  }
}
