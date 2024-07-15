Feature: Login as a registered user

  Rule: Login to the web application

  If I click on the Sign-in button, a login page is displayed
  where I can enter my credentials and after clicking on the Sign-in button
  my user profile is available for me.

    Background:

      Given I am a registered user
      And I open the home page
      And I accept the cookies

    Scenario:

      When I click on the Sign-in button
      Then a Login page is displayed
      And I can enter my e-mail address
      And I can enter my password
      And when I click on the Sign-in button
      Then I receive a greeting message
      And my user profile is made available for me.