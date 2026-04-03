@Web @Logout
Feature: US-04: Logout
  As an admin user, I want to securely log out of the system so that my session is safely closed.

  Background:
    Given User is already logged in as Admin
    And User is on the Dashboard page

  @Positive
  Scenario: Successful logout and redirection to the login screen
    When User clicks on the user profile dropdown menu
    And Clicks on the Logout option
    Then User should be navigated back to the login screen
