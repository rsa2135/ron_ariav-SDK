package utils;

import static com.google.common.truth.Truth.assertThat;
import static utils.Sorter.Direction.DESC;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class SorterTest {

  @Nested
  @DisplayName("getQuery")
  class GetQuery {

    @Test
    @DisplayName("returns empty string when no values are provided")
    void returnsCorrectStringWhenNoValues() {
      final Sorter sorter = new Sorter();
      assertThat(sorter.getQuery()).isEqualTo("");
    }

    @Test
    @DisplayName("returns the correct query when all values are provided")
    void returnsCorrectStringWhenAllValue() {
      final Sorter sorter = new Sorter("name", DESC);
      assertThat(sorter.getQuery()).isEqualTo("sort=name:desc");
    }
  }
}
