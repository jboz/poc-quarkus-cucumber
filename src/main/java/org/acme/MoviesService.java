package org.acme;

import java.util.List;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MoviesService {

    @Inject
    MoviesStoreInMemory moviesStore;

    public List<Movie> getAll() {
        Log.info("Getting all movies from the Movies Store");
        return moviesStore.getAll();
    }
}
