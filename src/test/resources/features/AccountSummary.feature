@ZB_002
Feature: Account summary all page verification

  Background:
    Given the user is logged in
    When the "Account Summary" page should be displayed

  @account_summary_types
  Scenario: Account types check
    Then following account types should be displayed
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  @account_summary_table
  Scenario: Account table columns check
    Then following columns at Credit Accounts table should be displayed
      | Account     |
      | Credit Card |
      | Balance     |