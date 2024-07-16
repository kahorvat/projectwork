Feature: Search for a product

  Rule:

  If I enter a specific keyword for search
  then all the products containing that specific keyword are displayed in a list.

    Background:

      Given I open the home page
      And I accept the cookies

    Scenario Outline: Search for a product

      When  I search for a product <productName>
      Then products are displayed <numberOfProducts>
      And the name of the product contains <productName>
      And the result page shows the keyword I was searching with "<productName>"

      Examples:
        | productName         | numberOfProducts  |
        | dinnye              | 21                |
        | energiaital         | 9                 |
        | fagyasztott gyümölcs| 22                |


  Rule: If I search for a product that is not available, a warning message is displayed

    Background: :
      Given I open the home page
      And I accept the cookies

    Scenario:  Search for a product that is not available

      When I search for "Q012"
      Then a message is displayed that the product is not available
      And the "Start shopping" button is displayed
      And the "Search" button is displayed

