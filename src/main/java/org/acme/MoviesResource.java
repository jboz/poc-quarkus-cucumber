package org.acme;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/movies")
@Produces(MediaType.APPLICATION_JSON)
public class MoviesResource {

    @Inject
    MoviesService moviesService;

    @GET
    public List<Movie> movies() {
        return moviesService.getAll();
    }
}
