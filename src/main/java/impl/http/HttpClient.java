package impl.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import utils.Options;
import utils.UrlDeserializer;

public class HttpClient {
  private static final Gson gson =
      new GsonBuilder().registerTypeAdapter(URL.class, new UrlDeserializer()).create();
  private static final String SLASH = "/";
  private static final String BASE_URL = "https://the-one-api.dev/v2/";

  private static final reactor.netty.http.client.HttpClient httpClient =
      reactor.netty.http.client.HttpClient.create().port(443).baseUrl(BASE_URL);

  public <T> Mono<T> makeGetRequestThatMapsToAMono(String endPoint, Class<T> clazz, Options opts) {
    return makeGetRequestThatMapsToAFlux(endPoint, clazz, opts).next();
  }

  public <T> Flux<T> makeGetRequestThatMapsToAFlux(String endPoint, Class<T> clazz, Options opts) {
    return makeGetRequest(endPoint + opts.buildQuery())
        .response(
            (response, bytes) ->
                bytes.aggregate().asInputStream().flatMapIterable(s -> deserialize(s, clazz)));
  }

  private reactor.netty.http.client.HttpClient.ResponseReceiver<?> makeGetRequest(String endPoint) {
    return httpClient.headers(this::setKey).get().uri(SLASH + endPoint);
  }

  private <T> List<T> deserialize(InputStream response, Class<T> clazz) {

    final JsonObject jsonObject = gson.fromJson(new InputStreamReader(response), JsonObject.class);

    JsonElement docs;
    try {
      docs = jsonObject.get("docs");
      StreamSupport.stream(docs.getAsJsonArray().spliterator(), true)
          .map(JsonElement::getAsJsonObject)
          .forEach(obj -> obj.add("id", obj.remove("_id")));

      final Type type = TypeToken.getParameterized(Collection.class, clazz).getType();
      return gson.fromJson(docs, type);
    } catch (NullPointerException err) {

      if (jsonObject.has("message")
          && jsonObject.get("message").getAsString().equals("Unauthorized.")) {
        System.out.println("UNAUTHORIZED");
      } else {
        System.out.println(err.getMessage());
      }
      return Collections.emptyList();
    }
  }

  private void setKey(HttpHeaders h) {
    try {
      Path path = Paths.get(getClass().getClassLoader().getResource("key.txt").getFile());
      List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
      final Optional<String> key = allLines.stream().findFirst();
      key.ifPresent(s -> h.set("Authorization", "Bearer " + s));
    } catch (IOException e) {
      System.out.println("key not found, proceeding...");
    }
  }
}
