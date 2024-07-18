Feature: Empty shopping cart

  Rule: items in the shopping cart can be deleted

  If the user decides not to buy the items collected in the shopping cart, all the items from the cart
  should be deleted on a single click.

    Background:

      Given I open the home page
      And I accept the cookies
      And I log in
      And I have products in my shopping cart

    Scenario:

      When I click on "view full basket"
      And I select "Empty trolley" button
      Then all the items are removed from my basket
      And I have a warning message "Your trolley is empty".
