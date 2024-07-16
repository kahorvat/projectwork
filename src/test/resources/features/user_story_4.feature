Feature: Change the language of the web page

  Rule: change language from English to Magyar

  If I click on the English button in the menu bar
  then the page is reloaded
  and all description on the page is displayed in English.

    Background:

      Given I open the home page
      And I accept the cookies

    Scenario:

      When I click on the English button in the menu bar
      Then the page is reloaded
      And the language is switched to English.

  Rule: change language from Magyar to English

  If I click on the Magyar button in the menu bar
  then the page is reloaded
  and all description on the page is displayed in Hungarian.

    Background:

      Given I open the home page
      And I accept the cookies
      And I click on the English button

    Scenario:

      When I click on the Magyar button in the menu bar
      Then the page is reloaded
      And the language is switched to Hungarian.

