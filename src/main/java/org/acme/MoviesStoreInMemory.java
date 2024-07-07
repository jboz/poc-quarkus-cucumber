package org.acme;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MoviesStoreInMemory {
    private final List<Movie> movies = List.of(
            new Movie("Star Wars", 1977),
            new Movie("Back to the Future", 1985),
            new Movie("The Matrix", 1999));

    List<Movie> getAll() {
        return movies;
    }
}
