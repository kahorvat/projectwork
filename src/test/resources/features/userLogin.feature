Feature: Login as a registered user

  Rule: Login to the web application

  If I click on the Sign-in button, a login page is displayed
  where I can enter my credentials and after clicking on the Sign-in button
  my user profile is available for me.

    Background:

      Given I open the home page
      And I accept homepage cookies
      And I navigate to the Sign-in page

    Scenario:

      When I login with e-mail "horvath_karoly@yahoo.com" and password "KareszTesco11++"
      Then a greeting message is displayed
      And my user profile is available





