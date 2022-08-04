package impl.domain;

public class Movie {
  String id;
  String name;
  Integer runtimeInMinutes;
  Integer budgetInMillions;
  Integer boxOfficeRevenueInMillions;
  Integer academyAwardNominations;
  Integer academyAwardWins;
  Integer rottenTomatoesScore;

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Integer getRuntimeInMinutes() {
    return runtimeInMinutes;
  }

  public Integer getBudgetInMillions() {
    return budgetInMillions;
  }

  public Integer getBoxOfficeRevenueInMillions() {
    return boxOfficeRevenueInMillions;
  }

  public Integer getAcademyAwardNominations() {
    return academyAwardNominations;
  }

  public Integer getAcademyAwardWins() {
    return academyAwardWins;
  }

  public Integer getRottenTomatoesScore() {
    return rottenTomatoesScore;
  }

  @Override
  public String toString() {
    return "Movie{"
        + "id='"
        + id
        + '\''
        + ", name='"
        + name
        + '\''
        + ", runtimeInMinutes="
        + runtimeInMinutes
        + ", budgetInMillions="
        + budgetInMillions
        + ", boxOfficeRevenueInMillions="
        + boxOfficeRevenueInMillions
        + ", academyAwardNominations="
        + academyAwardNominations
        + ", academyAwardWins="
        + academyAwardWins
        + ", rottenTomatoesScore="
        + rottenTomatoesScore
        + '}';
  }
}
