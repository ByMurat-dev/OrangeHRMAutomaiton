@Mobile @Scroll
Feature: US-MOB-03: Scroll and Navigation
  As a mobile user, I want to scroll through a list to find a specific item and open its detail screen.

  Background:
    Given The user launches the ApiDemos application

  @Positive
  Scenario: Scroll to find a target item and open its detail screen
    When The user taps on the "Views" menu
    And The user scrolls down to find the "WebView" item
    And The user taps on the "WebView" item
    Then The "WebView" detail screen should be opened successfully
