Feature: 
  BookCart Application demo

  Background: 
    Given User should navigate to the application
    And User should click on login link
@smoke
  Scenario: Successfull login
    And User should enter user name as ortoni
    When User should enter password as pass1234
    Then User should sign successfull
@sanity @reg
  Scenario: Failure login
    And User should enter user name as "ortoni"
    When User should enter password as "pass12"
    But Login should failed
