package api.manager;

import impl.domain.Chapter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import utils.Options;

public interface ChapterManager {
  Flux<Chapter> getAllChapters(Options opts);

  Mono<Chapter> getChapterById(String chapterId, Options opts);

  Flux<Chapter> getChaptersByBook(String bookId, Options opts);
}
