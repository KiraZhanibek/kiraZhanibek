@TEC-102 @ui  @regrassionTest
Feature: Adding Order
  @smokeTest
  Scenario: Verify create order functionality
    Given  navigate to login page
    Then  user logs in with valid credentials username "Tester" password "test"
    And User clicks on Order
    Then user creates new Order
      | Product Name | Quantity | Customer Name | Street | City    | State | Zip   | Card Number | Expire Date |
      | ScreenSaver  | 2        | Techtorial    | 123 N tech | Chicago | Il    | 60000 | 1234567567  | 12/21       |
    Then User verifies Order is created


    Scenario: Verify create order functionality with invalid data
      Given  navigate to login page
      Then  user logs in with valid credentials username "Tester" password "test"
      Then User clicks on Order
      Then user creates new Order
        | Product Name | Quantity | Customer Name | Street | City    | State | Zip   | Card Number | Expire Date |
        | ScreenSaver  | 2        | Techtorial    | 123 N tech | Chicago | Il    | zipCode | 1234567567  | 12/21       |

      Then User verifies Order is not created


     @Tech-1015 @smokeTest
     Scenario Outline: Verify Delete functionality
       Given  navigate to login page
       Then user logs in with valid credentials username "Tester" password "test"
       And User deletes "<Name>" from table
       Then User vaidate that "<Name>" is deleted
       Examples:
       |Name          |
       |Mark Smith    |
       |Samuel Clemens|
       |Paul Brown    |
