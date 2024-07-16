Feature: Check if delivery is available in my area

  Rule:

  If I enter a valid ZIP code within Budapest
  and click on verify button,
  I should receive a positive text result
  and an order online button should appear on the page.


    Background:

      Given I open the delivery check page
      And I accept the cookies

    Scenario Outline: Verify valid ZIP code

      When I enter a valid ZIP code "<ZIP_codes>"
      And I search for the ZIP code "<ZIP_codes>"
      Then I should see the "<positive_result_text>"

      Examples:

        | ZIP_codes   | positive_result_text   |
        | 1112        | Jó hírünk van!	       |
        | 1221        | Jó hírünk van!         |


  Rule:

  If I enter an invalid ZIP code,
  and click on the verify button,
  I should receive a negative text result
  and the order online button should not appear on the page.

    Background:

      Given I open the delivery check page
      And I accept the cookies

    Scenario Outline: Verify invalid ZIP code

      When I enter an invalid ZIP code "<invalid_ZIP_codes>"
      And I search for the invalid ZIP code "<invalid_ZIP_codes>"
      Then I should get the "<negative_result_text>"


      Examples:

        | invalid_ZIP_codes    | negative_result_text                                     |
        | 15789                | Sajnáljuk, de jelenleg még nem tudunk szállítani hozzád. |
        | 23410                | Sajnáljuk, de jelenleg még nem tudunk szállítani hozzád. |

