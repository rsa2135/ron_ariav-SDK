package impl.domain;

import java.net.URL;

public class Chararcter {
  String name;
  URL wikiUrl;
  String race;
  String birth;
  String gender;
  String death;
  String hair;
  String height;
  String realm;
  String spouse;

  public String getName() {
    return name;
  }

  public URL getWikiUrl() {
    return wikiUrl;
  }

  public String getRace() {
    return race;
  }

  public String getBirth() {
    return birth;
  }

  public String getGender() {
    return gender;
  }

  public String getDeath() {
    return death;
  }

  public String getHair() {
    return hair;
  }

  public String getHeight() {
    return height;
  }

  public String getRealm() {
    return realm;
  }

  public String getSpouse() {
    return spouse;
  }

  @Override
  public String toString() {
    return "Chararcter{"
        + "name='"
        + name
        + '\''
        + ", wikiUrl="
        + wikiUrl
        + ", race='"
        + race
        + '\''
        + ", birth='"
        + birth
        + '\''
        + ", gender='"
        + gender
        + '\''
        + ", death='"
        + death
        + '\''
        + ", hair='"
        + hair
        + '\''
        + ", height='"
        + height
        + '\''
        + ", realm='"
        + realm
        + '\''
        + ", spouse='"
        + spouse
        + '\''
        + '}';
  }
}
