import api.manager.*;
import impl.domain.*;
import impl.http.HttpClient;
import impl.manager.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import utils.Options;

public class LOTRClient
    implements BookManager, ChapterManager, CharacterManager, MovieManager, QuoteManager {
  final BookManager bookManager;
  final ChapterManager chapterManager;
  final CharacterManager characterManager;
  final MovieManager movieManager;
  final QuoteManager quoteManager;

  public LOTRClient() {
    final HttpClient client = new HttpClient();
    bookManager = new BookManagerImpl(client);
    chapterManager = new ChapterManagerImpl(client);
    characterManager = new CharacterManagerImpl(client);
    movieManager = new MovieManagerImpl(client);
    quoteManager = new QuoteManagerImpl(client);
  }

  @Override
  public Flux<Book> getAllBooks(Options opts) {
    return bookManager.getAllBooks(opts);
  }

  @Override
  public Mono<Book> getBookById(String bookId, Options opts) {
    return bookManager.getBookById(bookId, opts);
  }

  @Override
  public Flux<Chapter> getAllChapters(Options opts) {
    return chapterManager.getAllChapters(opts);
  }

  @Override
  public Mono<Chapter> getChapterById(String chapterId, Options opts) {
    return chapterManager.getChapterById(chapterId, opts);
  }

  @Override
  public Flux<Chapter> getChaptersByBook(String bookId, Options opts) {
    return chapterManager.getChaptersByBook(bookId, opts);
  }

  @Override
  public Flux<Chararcter> getAllCharacters(Options opts) {
    return characterManager.getAllCharacters(opts);
  }

  @Override
  public Mono<Chararcter> getCharacterById(String characterId, Options opts) {
    return characterManager.getCharacterById(characterId, opts);
  }

  @Override
  public Flux<Movie> getAllMovies(Options opts) {
    return movieManager.getAllMovies(opts);
  }

  @Override
  public Mono<Movie> getMovieById(String movieId, Options opts) {
    return movieManager.getMovieById(movieId, opts);
  }

  @Override
  public Flux<Quote> getAllQuotes(Options opts) {
    return quoteManager.getAllQuotes(opts);
  }

  @Override
  public Mono<Quote> getQuoteById(String quoteId, Options opts) {
    return quoteManager.getQuoteById(quoteId, opts);
  }

  @Override
  public Flux<Quote> getQuotesByCharacter(String characterId, Options opts) {
    return quoteManager.getQuotesByCharacter(characterId, opts);
  }

  @Override
  public Flux<Quote> getQuotesByMovie(String movieId, Options opts) {
    return quoteManager.getQuotesByMovie(movieId, opts);
  }
}
