package impl.manager;

import api.manager.BookManager;
import impl.domain.Book;
import impl.http.HttpClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import utils.Options;

public class BookManagerImpl implements BookManager {
  private final HttpClient httpClient;

  public BookManagerImpl(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  @Override
  public Flux<Book> getAllBooks(Options opts) {
    return httpClient.makeGetRequestThatMapsToAFlux("book", Book.class, opts);
  }

  @Override
  public Mono<Book> getBookById(String bookId, Options opts) {
    return httpClient.makeGetRequestThatMapsToAMono("book" + "/" + bookId, Book.class, opts);
  }
}
