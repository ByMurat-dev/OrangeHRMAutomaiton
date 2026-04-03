@Web @Login
Feature: US-01: Admin Login
  As an admin user, I want to log in to the OrangeHRM system so that I can access the Dashboard.

  Background:
    Given User is on the OrangeHRM login page

  @Positive
  Scenario: Successful login with valid credentials
    When User enters valid username and password
    And Clicks on the login button
    Then User should be redirected to the Dashboard page

  @Negative
  Scenario Outline: Unsuccessful login with invalid credentials
    When User enters username "<username>" and password "<password>"
    And Clicks on the login button
    Then User should see an invalid credentials error message

    Examples:
      | username | password |
      | Admin    | wrong123 |
      | wrongUsr | admin123 |
      | invalid  | invalid  |

  @Negative
  Scenario: Login validation with empty fields
    When User clicks on the login button without entering any credentials
    Then Required field validation messages should be displayed for both fields