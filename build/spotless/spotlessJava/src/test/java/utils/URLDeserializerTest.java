package utils;

import static com.google.common.truth.Truth.assertThat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import impl.domain.Chararcter;
import java.net.URL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class URLDeserializerTest {

  Gson gson;

  @BeforeEach
  void setUp() {
    gson = new GsonBuilder().registerTypeAdapter(URL.class, new UrlDeserializer()).create();
  }

  @Nested
  @DisplayName("read")
  class Read {

    @Test
    @DisplayName("when present, deserializes textual urls into URL objects")
    void deserializesIntoURL() {
      String json =
          "{\n"
              + "      \"id\": \"5cd99d4bde30eff6ebccfc15\",\n"
              + "      \"height\": \"1.06m (3'6\\\")\",\n"
              + "      \"race\": \"Hobbit\",\n"
              + "      \"gender\": \"Male\",\n"
              + "      \"birth\": \"22 September ,TA 2968\",\n"
              + "      \"spouse\": \"\",\n"
              + "      \"death\": \"Unknown (Last sighting ,September 29 ,3021,) (,SR 1421,)\",\n"
              + "      \"realm\": \"\",\n"
              + "      \"hair\": \"Brown\",\n"
              + "      \"name\": \"Frodo Baggins\",\n"
              + "      \"wikiUrl\": \"http://lotr.wikia.com//wiki/Frodo_Baggins\"\n"
              + "    }";
      final Chararcter chararcter = gson.fromJson(json, Chararcter.class);
      final URL wikiUrl = chararcter.getWikiUrl();
      assertThat(wikiUrl.toString()).isEqualTo("http://lotr.wikia.com//wiki/Frodo_Baggins");
    }

    @Test
    @DisplayName("when malformed url is present, it skips deserialization and returns null")
    void skipsDeserializesWhenMalformed() {
      String json =
          "{\n"
              + "      \"id\": \"5cd99d4bde30eff6ebccfc15\",\n"
              + "      \"height\": \"1.06m (3'6\\\")\",\n"
              + "      \"race\": \"Hobbit\",\n"
              + "      \"gender\": \"Male\",\n"
              + "      \"birth\": \"22 September ,TA 2968\",\n"
              + "      \"spouse\": \"\",\n"
              + "      \"death\": \"Unknown (Last sighting ,September 29 ,3021,) (,SR 1421,)\",\n"
              + "      \"realm\": \"\",\n"
              + "      \"hair\": \"Brown\",\n"
              + "      \"name\": \"Frodo Baggins\",\n"
              + "      \"wikiUrl\": \"\"\n"
              + "    }";
      final Chararcter chararcter = gson.fromJson(json, Chararcter.class);
      final URL wikiUrl = chararcter.getWikiUrl();
      assertThat(wikiUrl).isEqualTo(null);
    }
  }
}
