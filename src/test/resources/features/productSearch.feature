Feature: Search for a product

  Rule:

  If I enter a specific keyword for search
  then all the products containing that specific keyword are displayed in a list.

    Background:

      Given I open the home page
      And I accept homepage cookies

    Scenario Outline: Search for a product

      When I search for a product "<productName>"
      Then products are displayed "<numberOfProducts>"
      And the name of the product contains "<productName>"
      And the result page shows "<productName>"

      Examples:
        | productName | numberOfProducts |
        | energiaital | 8                |



  Rule: If I search for a product that is not available, a warning message is displayed

    Background: :
      Given I open the home page
      And I accept homepage cookies

    Scenario:  Search for a product that is not available

      When I search for "Q012"
      Then a warning message is displayed
      And the start shopping button is displayed


