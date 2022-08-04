package api.manager;

import impl.domain.Quote;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import utils.Options;

public interface QuoteManager {
  Flux<Quote> getAllQuotes(Options opts);

  Mono<Quote> getQuoteById(String quoteId, Options opts);

  Flux<Quote> getQuotesByCharacter(String characterId, Options opts);

  Flux<Quote> getQuotesByMovie(String movieId, Options opts);
}
