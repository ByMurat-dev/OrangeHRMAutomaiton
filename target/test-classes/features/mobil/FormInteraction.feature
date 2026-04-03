@Mobile @FormInteraction
Feature: US-MOB-02: Form Interaction
  As a mobile user, I want to navigate to the controls screen and interact with form elements so that I can verify input fields and checkboxes work correctly.

  Background:
    Given The user launches the ApiDemos application

  @Positive
  Scenario: Navigate to Light Theme and interact with inputs and checkboxes
    When The user taps on the "Views" menu
    And The user taps on the "Controls" option
    And The user taps on the "1. Light Theme" option
    And The user enters "QA Automation Test" into the text input field
    And The user taps on the checkbox to toggle its state
    Then The checkbox should be selected