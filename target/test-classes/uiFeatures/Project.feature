@ProjectDay
Feature: Adding below data  to your excel file in Sheets;

  Scenario:
    Given Go to Databaseand get First name and Last name of employees who works in Europe and validate withtheirUI information
    And Go to Excel and update column ‘Actual # of Employees’ with number of Europe employees that you get from UI
    Then Compare ‘Actual # of Employees’’ with ‘expected # of Employees’ and if they matched then update ‘Test Execution Status’ cell as PASSEDif not match then update with FAILED.
