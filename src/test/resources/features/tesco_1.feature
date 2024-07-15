Feature: Check if delivery is available in my area

  Rule:

  If I enter a valid ZIP code within Budapest
  and click on verify button,
  I should receive a positive text result
  and an order online button should appear on the page.


    Background:

      Given I open the home page
      And I accept the cookies
      And I click on the link "Hova szállítunk?"

    Scenario Outline: Verify valid ZIP code

      When I enter a valid ZIP code <ZIP codes>
      And I click on the verify button
      Then I should see the <positive result text>

      Examples:

        | ZIP codes   | positive result text   |
        | 1112        | Jó hírünk van!	       |
        | 1221        | Jó hírünk van!         |


  Rule:

  If I enter an invalid ZIP code,
  and click on the verify button,
  I should receive a negative text result
  and the online button should not appear on the page.

    Scenario Outline: Verify invalid ZIP code

      When I enter an invalid ZIP code <invalid ZIP codes>
      And I click on the verify button
      Then I should see the <negative result text>


      Examples:

        | invalid ZIP codes    | negative result text                                     |
        | 15789                | Sajnáljuk, de jelenleg még nem tudunk szállítani hozzád. |
        | 23410                | Sajnáljuk, de jelenleg még nem tudunk szállítani hozzád. |

