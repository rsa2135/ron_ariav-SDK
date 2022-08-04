package utils;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class UrlDeserializer extends TypeAdapter<URL> {

  @Override
  public void write(JsonWriter out, URL value) throws IOException {
    out.value(value.toString());
  }

  @Override
  public URL read(JsonReader in) throws IOException {
    String url = in.nextString();
    return !Objects.equals(url, "") ? new URL(url) : null;
  }
}
