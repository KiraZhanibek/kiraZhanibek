@ProjectDay
Feature: Adding below data  to your excel file in Sheets;

  Scenario:
    Given Go to Database and get First name and Last name of employees who works in Europe and validate withtheirUI information
    And Go to Excel and update column ‘Actual # of Employees’ with number of Europe employees that you get from UI
    Then Compare ‘Actual # of Employees’’ with ‘expected # of Employees’ and if they matched then update ‘Test Execution Status’ cell as PASSEDif not match then update with FAILED.

    Scenario:
      Given Go to Databaseand get Department Nameand number of ‘Active’employeesand validate with their UI numbers.
      And Go to Excel and update column ‘Actual # of Employees’ with number of Activeemployees that you get from UI and compare that number with ‘expected # of Employees’ and if they matched then update ‘Test Execution Status’ cell as PASSEDif not match then update with FAILED.