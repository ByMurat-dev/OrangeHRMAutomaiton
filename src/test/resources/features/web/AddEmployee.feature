@Web @AddEmployee
Feature: US-02: Add Employee
  As an admin user, I want to add a new employee to the system and complete their profile details.

  Background:
    Given User is already logged in as Admin
    And User is on the Dashboard page

  @Positive
  Scenario: Successfully adding a new employee and completing the profile
    When User navigates to the PIM module
    And Clicks on the Add Employee button
    And Enters First Name "QA" and Last Name "Automation"
    And Clicks on the Save employee button
    Then The Employee Profile screen should be opened
    When User fills in additional profile details like Nationality and Marital Status
    And Clicks on the Save button in the Personal Details section
    Then The employee registration should be successfully completed