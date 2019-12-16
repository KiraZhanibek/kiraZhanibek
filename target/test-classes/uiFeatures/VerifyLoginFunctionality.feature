@Project3 @ui @smokeTest
Feature: Verifying Login functionality

  Background:Common first steps
    Given  navigate to login page
  @ui
  Scenario: Verifying with valid credentials
    Then  user logs in with valid credentials username "Tester" password "test"
    And Verify user is in Homepage

  Scenario: Varifying with invalid credentials
    Then  user logs in with invalid credentials username "Testers" password "test"
    And Verify user gets error message "Invalid Login or Password."





