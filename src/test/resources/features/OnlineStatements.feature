@ZB_009
Feature: Online statement visualization
  User should be check statements for all account types

  Background:
    Given the user is logged in
    Then  the user accesses the "Online Statements"

  @dropdown_options
  Scenario: Verify default and all options of dropdown
    Then the "Online Statements" page should be displayed
    And Verify that default dropdown option should be "Savings"
    And Verify following account names under account dropdown
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |

    Then After select following account names then Verify same account name in board header
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |


  @recent_statements
  Scenario Outline: Verify recent statements selections and documentations
    Given After click "<year>" ,verify that active year should be change
    Then Statements dates year should be same with following "<year>"
    Examples:
      | year |
      | 2012 |
      | 2011 |
      | 2010 |
      | 2009 |