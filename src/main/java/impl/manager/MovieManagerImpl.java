package impl.manager;

import api.manager.MovieManager;
import impl.domain.Movie;
import impl.http.HttpClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import utils.Options;

public class MovieManagerImpl implements MovieManager {
  private final HttpClient httpClient;
  private final Class<Movie> clazz;

  public MovieManagerImpl(HttpClient httpClient) {
    this.httpClient = httpClient;
    this.clazz = Movie.class;
  }

  @Override
  public Flux<Movie> getAllMovies(Options opts) {
    return this.httpClient.makeGetRequestThatMapsToAFlux("movie", this.clazz, opts);
  }

  @Override
  public Mono<Movie> getMovieById(String movieId, Options opts) {
    return this.httpClient.makeGetRequestThatMapsToAMono("movie/" + movieId, this.clazz, opts);
  }
}
