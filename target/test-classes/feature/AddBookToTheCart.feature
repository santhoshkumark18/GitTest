Feature: 
  Add Book to the Cart in Book Cart Application

  Scenario Outline: Check the Cart count after adding a book
    Given user should navigate to application
    Then user click on loing button
    And user should enter id "<userid>"
    And user should enter pass "<password>"
    When user should search "<book>" and add to cart
    Then cart iteam should be increased

    Examples: 
      | userid   | password | book                                    |
      | ortonikc | pass1234 | harry potter and the chamber of secret |
