package utils;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class FilterTest {

  @Nested
  @DisplayName("getQuery")
  class GetQuery {

    @Test
    @DisplayName("returns an empty string when no values are provided")
    void returnsEmptyStringWhenNoValues() {
      final Filter filter = new Filter();
      assertThat(filter.getQuery()).isEqualTo("");
    }

    @Test
    @DisplayName("returns the correct query when any values are provided")
    void returnsCorrectStringWhenAnyValue() {
      final Filter filter = new Filter("race=Hobbit,Human");
      assertThat(filter.getQuery()).isEqualTo("race=Hobbit,Human");
    }
  }
}
