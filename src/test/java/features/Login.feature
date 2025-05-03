@Login
Feature: Login function

  Scenario Outline: Successful login with valid credentials
    Given the user navigates to the homepage
    And the user clicks on the login button
    When the user enters "<email>" and "<password>"
    Then clicks on the 'daxil ol' button and proceeds to the homepage

    Examples:
      | email               | password |
      | john.doe@gmail.com | 123456789 |