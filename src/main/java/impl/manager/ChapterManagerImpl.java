package impl.manager;

import api.manager.ChapterManager;
import impl.domain.Chapter;
import impl.http.HttpClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import utils.Options;

public class ChapterManagerImpl implements ChapterManager {
  private final HttpClient httpClient;
  private final Class<Chapter> clazz;

  public ChapterManagerImpl(HttpClient httpClient) {
    this.httpClient = httpClient;
    this.clazz = Chapter.class;
  }

  @Override
  public Flux<Chapter> getAllChapters(Options opts) {
    return httpClient.makeGetRequestThatMapsToAFlux("chapter", clazz, opts);
  }

  @Override
  public Mono<Chapter> getChapterById(String chapterId, Options opts) {
    return httpClient.makeGetRequestThatMapsToAMono("chapter/" + chapterId, clazz, opts);
  }

  @Override
  public Flux<Chapter> getChaptersByBook(String bookId, Options opts) {
    return httpClient
        .makeGetRequestThatMapsToAFlux("book/" + bookId + "/chapter/", clazz, opts)
        .map(chap -> new Chapter(chap.getId(), chap.getName(), bookId));
  }
}
