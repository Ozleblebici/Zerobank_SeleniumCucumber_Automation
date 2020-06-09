@ZB_003  @account_activity
Feature: Account Activity all page verifications
         Default option, Account drop down options and Transactions table column names should be followings data

  Background:
    Given the user is logged in
    Then the user accesses the "Account Activity"
    When  the "Account Activity" page should be displayed

  @drop_down_check
  Scenario: Account dropdown options check
    Then the account drop down default option should be "Savings"
    And following drop down options should be have
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  @header_check
  Scenario: Account table columns header check
    And following columns name at Transactions table should be have
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |
