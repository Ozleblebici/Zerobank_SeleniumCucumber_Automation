@ZB_001 @login
Feature: Only authorized users should be able to login to the application.


  @positive
  Scenario: Login with valid credentials
    Given the user is logged in
    Then the "Account Summary" page should be displayed

  @negative
  Scenario: Login with invalid wrong credentials
    Given the user should not be able to login with wrong credentials
    Then login error message should be displayed

  @negative
  Scenario: Login with invalid blank credentials
    Given the user should not be able to login with blank credentials
    Then login error message should be displayed