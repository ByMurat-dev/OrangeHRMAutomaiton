@Mobile @AlertDialog
Feature: US-MOB-04: Alert Dialog Handling
  As a mobile user, I want to interact with alert dialogs so that I can verify OK or Cancel actions are working as expected.

  Background:
    Given The user launches the ApiDemos application

  @Positive
  Scenario: Open an alert dialog and verify the OK action
    When The user taps on the "App" menu
    And The user taps on the "Alert Dialogs" option
    And The user taps on the "OK Cancel dialog with a message" button
    Then An alert dialog should be displayed on the screen
    When The user taps on the "OK" button on the alert
    Then The alert dialog should be closed successfully
