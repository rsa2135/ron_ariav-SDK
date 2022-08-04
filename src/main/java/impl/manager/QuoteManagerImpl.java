package impl.manager;

import api.manager.QuoteManager;
import impl.domain.Quote;
import impl.http.HttpClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import utils.Options;

public class QuoteManagerImpl implements QuoteManager {
  private final HttpClient httpClient;
  private final Class<Quote> clazz;

  public QuoteManagerImpl(HttpClient httpClient) {
    this.httpClient = httpClient;
    this.clazz = Quote.class;
  }

  @Override
  public Flux<Quote> getAllQuotes(Options opts) {
    return this.httpClient.makeGetRequestThatMapsToAFlux("quote", this.clazz, opts);
  }

  @Override
  public Mono<Quote> getQuoteById(String quoteId, Options opts) {
    return this.httpClient.makeGetRequestThatMapsToAMono("quote/" + quoteId, this.clazz, opts);
  }

  @Override
  public Flux<Quote> getQuotesByCharacter(String characterId, Options opts) {
    return this.httpClient.makeGetRequestThatMapsToAFlux(
        "character/" + characterId + "/quote", this.clazz, opts);
  }

  @Override
  public Flux<Quote> getQuotesByMovie(String movieId, Options opts) {
    return this.httpClient.makeGetRequestThatMapsToAFlux(
        "movie/" + movieId + "/quote", this.clazz, opts);
  }
}
