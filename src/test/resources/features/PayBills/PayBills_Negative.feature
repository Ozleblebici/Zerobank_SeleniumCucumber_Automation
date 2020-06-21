@ZB_004 @pay_bills
Feature: Pay Bills all page verifications

  @negative @outline
  Scenario Outline: Unsuccessful pay operation with <test_type>
    Given the user is logged in
    Then the user accesses the "<module_name>"
    When  the "<expected_title>" page should be displayed
    And the user completes a Pay operation with these "<amount>" and "<date>"
    Then validation message "Please fill in this field." should be displayed at "<message_line>"
    Examples: Credential Info
      | module_name | expected_title | amount  | date       | message_line | test_type      |
      | Pay Bills   | Pay Bills      | 1000    |            | date         | Blank Date     |
      | Pay Bills   | Pay Bills      |         | 2020-09-09 | amount       | Blank Amount   |
      | Pay Bills   | Pay Bills      | abc*/_+ | 2020-09-09 | amount       | Invalid Amount |
      | Pay Bills   | Pay Bills      | 5000    | abcd       | date         | Invalid Date   |