package api.manager;

import impl.domain.Chararcter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import utils.Options;

public interface CharacterManager {
  Flux<Chararcter> getAllCharacters(Options opts);

  Mono<Chararcter> getCharacterById(String characterId, Options opts);
}
