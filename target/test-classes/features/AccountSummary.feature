@ZB_002
Feature: Account summary all page verification

  Background:
    Given the user is logged in

  @account_summary
  Scenario: Account types and table columns check
    Given the "Account Summary" page should be displayed
    Then following account types should be displayed
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

    And following columns at Credit Accounts table should be displayed
      | Account     |
      | Credit Card |
      | Balance     |