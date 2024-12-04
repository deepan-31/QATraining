@activity5
Feature: Login Test

  Scenario Outline: Testing Login with Example
    Given User is on Login page
    When User enters "<Username>" and "<Password>"
    Then Read the page title and confirmation message
    And Close the Browser
    Examples:
      | Username | Password |
      |admin     |password  |
      |user      |password  |
