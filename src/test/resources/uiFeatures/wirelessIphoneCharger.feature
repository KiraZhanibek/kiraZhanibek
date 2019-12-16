@Tec1013
  Feature: Searching wireless iphone charger
    Scenario: Searching wireless iphone charger
       Given  navigate to Home page
      Then  input you item  click search button
      And user click on free shipping button
      Then Verify user in free shipping page

      @Tech1014
      Scenario: Validating over price functionality
        Given  navigate to Home page
        When User searching for "carpet"
        And User click on Over Price checkbox
        Then user verifyies