@ZB_010 @My_Money_Map
Feature: Check and Control Summary Table under My Money Map
  Users  compares summary tables under the My Money map page tab

  @wip
  Scenario: Check the summary schema datas
    Given the user is logged in
    Given the user accesses the "My Money Map" tab
    When table should displays summaryrows
    Then system should compare infos between "Total Inflow" and "Deposits"
    Then system should compare infos between "Total Outflow" and "Spendings"
    Then verify "What's Left" amount is correct