@TEC-100

Feature: HR Management Application
  Scenario: Login as an Admin and changepasswordfor Fiona Grace and verify it is changed by signing in again
    Given navigate to  Orange login page
    Then user provides  logIn "Admin" and password "admin123"
    And Change password for Fiona Grace
    Then Verify is changed by singing in again

