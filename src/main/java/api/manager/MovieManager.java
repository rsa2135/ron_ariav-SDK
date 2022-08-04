package api.manager;

import impl.domain.Movie;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import utils.Options;

public interface MovieManager {
  Flux<Movie> getAllMovies(Options opts);

  Mono<Movie> getMovieById(String movieId, Options opts);
}
