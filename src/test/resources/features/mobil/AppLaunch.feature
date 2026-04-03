@Mobile @AppLaunch
Feature: US-MOB-01: App Launch
  As a mobile user, I want to launch the ApiDemos application so that I can interact with its features.

  @Positive
  Scenario: Verify successful application launch and title visibility
    Given The user launches the ApiDemos application
    Then The application should be opened successfully
    And The title "API Demos" should be visible on the screen