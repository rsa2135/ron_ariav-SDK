# The Lord of the Rings SDK

## Usage

1. if in possession, add your API key to `key.txt` and place under `/src/main/resources/key.txt`
2. instantiate the HttpClient: `HttpClient client = new HttpClient();` this will allow you to make http calls to the API endpoints
3. Instantiate the appropriate manager(s) for the resources you are interested in interacting with and pass them the httpClient, e.g. `BookManager bookManager = new BookManagerImpl(client)`
4. Optionally, create an Options Object to pass Pagination/Filtering/Sorting queries:
    ```
    Options opts =
        new Options.OptionsBuilder()
            .withPaginator(new Paginator.PaginatorBuilder().limit(10).page(1).build())
            .withSorting(new Sorter("race", Sorter.Direction.DESC))
            .build();
    ```
5. Using the provided methods, query the API: `characterManager.getAllCharacters(opts).toStream().toList()` for `Flux` or `characterManager.getCharacterById(String id, opts).block()` for `Mono`;

**Alternatively, use `new LOTRClient()` which instantiates the `HTTPClient` and all available Managers and exposes all available methods.** 

## Testing
run `./gradlew test`
