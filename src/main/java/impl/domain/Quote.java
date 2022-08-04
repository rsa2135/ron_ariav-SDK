package impl.domain;

public class Quote {
  String dialog;
  String movieId;
  String characterId;

  public String getDialog() {
    return dialog;
  }

  public String getMovieId() {
    return movieId;
  }

  public String getCharacterId() {
    return characterId;
  }

  @Override
  public String toString() {
    return "Quote{"
        + "dialog='"
        + dialog
        + '\''
        + ", movieId='"
        + movieId
        + '\''
        + ", characterId='"
        + characterId
        + '\''
        + '}';
  }
}
