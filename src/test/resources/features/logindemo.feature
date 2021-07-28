Feature: Test login functionality
  @smoke
  Scenario Outline: Check login is successful with valid credentials
    Given user is on login page
    When user enters valid <username> and <password>
    And user clicks on login
    Then user is navigated to the home page

    Examples:
      | username | password |
      | chris | 12345 |
      | sylvia | 12345 |