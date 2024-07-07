package org.acme;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/database/movies")
@RegisterRestClient
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public interface MoviesStoreRestClient {

    @GET
    List<Movie> getAll();
}
