Feature: Testing my application
  @db @TECTC-108
  Scenario Outline: Validating ui data with Database
    Given naviagate to my application
    When user gets employee info for employee_id "<Employee_id>" from UI
    And User gets data for employee_id "<Employee_id>" from database
    Then Validate data are matching
    Examples:
    |Employeed_id|
    |100         |
    |105         |
    |119         |
    |125         |


