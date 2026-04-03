@Web @EmployeeSearch
Feature: US-03: Employee Search (PIM)
  As an admin user, I want to search for an employee in the PIM module so that I can view their details.

  Background:
    Given User is already logged in as Admin
    And User navigates to the PIM module
    And User is on the Employee List tab

  @Positive
  Scenario: Search for an employee by name and verify the result table
    When User enters the employee name "QA Automation" into the Employee Name search field
    And Clicks on the Search button
    Then The employee list should be filtered correctly
    And At least one record should be displayed in the results table
    And The "First (& Middle) Name" column in the results should contain "QA"