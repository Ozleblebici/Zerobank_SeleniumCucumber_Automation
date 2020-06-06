@ZB_004 @pay_bills
Feature: Pay Bills all page verifications

  Background:
    Given the user is logged in
    Then the user navigate to "Pay Bills" tab
    When  the "Pay Bills" page should be displayed

  @positive
  Scenario: Successful pay operation
    And the user completes a Pay operation with these "100" and "2020-09-09"

    Then message "The payment was successfully submitted." should be displayed

  @negative
  Scenario: Unsuccessful pay operation with blank data
    And the user completes a Pay operation with these "" and "2020-09-09"
    And the user completes a Pay operation with these "1000" and ""
    Then validation message "Please fill in this field message." should be displayed

  @negative
  Scenario: Unsuccessful pay operation with invalid
    And the user completes a Pay operation with these " abc*/_+" and "2020-09-09"
    And the user completes a Pay operation with these "5000" and "abcd"
    Then validation message "Please fill in this field message." should be displayed