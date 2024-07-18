Feature:  Filter for clubcard products

  Background:

    Given I open the home page
    And I accept the cookies

  Rule: clubcard products are displayed when clubcard filter is applied

  If I enter a specific keyword for search
  and I select clubcard árak (filter) on the search result page
  then products labeled with clubcard are displayed.


    Scenario Outline: Filter for clubcard products

      When I search for a product <productName>
      And I click on clubcard árak
      Then product description should contain a <label>

      Examples:
        | productName | label       |
        | dinnye      | Clubcard ár |
        | tej         | Clubcard ár |
