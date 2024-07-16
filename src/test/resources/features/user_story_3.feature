Feature:  Filter for clubcard products

  Background:

    Given I open the home page
    And I accept the cookies

  Rule:

  If I enter a specific keyword for search
    And I select "clubcard árak" on the search result page
      Then some products labeled with clubcard are displayed in the list.


    Scenario Outline: Filter for clubcard products

      When  I search for a product <productName>
      And I click on "clubcard árak" on the result page
      Then some of the products filtered should contain the text "Clubcard ár" <label>

      Examples:
        | productName | label       |
        | dinnye      | Clubcard ár |
        | tej         | Clubcard ár |
