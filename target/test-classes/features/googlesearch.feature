Feature: Google search
  Scenario: Validate Google search is working
    Given browser is open
    And user is in Google search page
    When user enters text in search box
    And hits enter
    Then user is navigated to search results