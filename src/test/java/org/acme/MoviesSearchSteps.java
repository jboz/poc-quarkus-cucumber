package org.acme;

import static io.restassured.RestAssured.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.hamcrest.Matchers;
import org.mockito.Mockito;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.ValidatableResponse;
import jakarta.inject.Inject;

@QuarkusTest
public class MoviesSearchSteps {

    @Inject
    MoviesStoreInMemory moviesStore;

    ValidatableResponse result;

    @Given("I have a movie called {string} in my movies store")
    public void iHaveAMovieCalledInMyMoviesStore(String movieName) {
        MoviesStoreInMemory moviesStore = Mockito.mock(MoviesStoreInMemory.class);
        when(moviesStore.getAll()).thenReturn(List.of(new Movie(movieName, 1999)));
        QuarkusMock.installMockForType(moviesStore, MoviesStoreInMemory.class);
    }

    @When("I press the search button")
    public void iPressTheSearchButton() {
        result = given()
                .when().get("/api/movies")
                .then().log().body();
    }

    @Then("I should see {string} in the results")
    public void iShouldSeeInTheResults(String searchText) {
        result.statusCode(200)
                .and().body("size()", Matchers.is(1))
                .and().body("[0].title", Matchers.equalTo(searchText));
    }

}
