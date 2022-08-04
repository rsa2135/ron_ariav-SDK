package api.manager;

import impl.domain.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import utils.Options;

public interface BookManager {
  Flux<Book> getAllBooks(Options opts);

  Mono<Book> getBookById(String bookId, Options opts);
}
