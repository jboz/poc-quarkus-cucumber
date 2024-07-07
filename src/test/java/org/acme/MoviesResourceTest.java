package org.acme;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class MoviesResourceTest {

    @InjectMock
    @RestClient
    MoviesStoreRestClient moviesStore;

    @Test
    void getAll() {
        Mockito.when(moviesStore.getAll()).thenReturn(List.of(new Movie("The Matrix", 1999)));
        given()
                .when().get("/api/movies")
                .then().statusCode(200)
                .log().body()
                .and().body("size()", Matchers.is(1))
                .and().body("[0].title", Matchers.equalTo("The Matrix"))
                .log().ifValidationFails();
    }
}
