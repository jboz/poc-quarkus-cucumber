Feature: search movies

  Scenario: Search for a movie by title
    Given I have a movie called "The Matrix" in my movies store
    When I press the search button
    Then I should see "The Matrix" in the results
