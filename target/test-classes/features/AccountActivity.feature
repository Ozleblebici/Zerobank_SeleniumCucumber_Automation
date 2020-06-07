@ZB_003
Feature: Account Activity all page verifications

  @account_activity
  Scenario: Account dropdown and table columns check
    Given the user is logged in
    Then the user accesses the "Account Activity"
    When  the "Account Activity" page should be displayed
    Then the account drop down default option should be "Savings"
    And following drop down options should be have
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |
    Then following columns name at Transactions table should be have
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |
