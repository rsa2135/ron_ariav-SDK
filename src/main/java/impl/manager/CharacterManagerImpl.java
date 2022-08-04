package impl.manager;

import api.manager.CharacterManager;
import impl.domain.Chararcter;
import impl.http.HttpClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import utils.Options;

public class CharacterManagerImpl implements CharacterManager {
  private final HttpClient httpClient;
  private final Class<Chararcter> clazz;

  public CharacterManagerImpl(HttpClient httpClient) {
    this.httpClient = httpClient;
    this.clazz = Chararcter.class;
  }

  @Override
  public Flux<Chararcter> getAllCharacters(Options opts) {
    return this.httpClient.makeGetRequestThatMapsToAFlux("character", this.clazz, opts);
  }

  @Override
  public Mono<Chararcter> getCharacterById(String characterId, Options opts) {
    return this.httpClient.makeGetRequestThatMapsToAMono(
        "character/" + characterId, this.clazz, opts);
  }
}
