Feature: Transactions

  @get-all-transactions
  Scenario: Get All Transactions
    Given I set GET api endpoints for get all transactions
    When I send GET HTTP Request for get all transactions
    Then I receive valid HTTP response code 200

  @post-transactions
  Scenario: Create Transactions
    Given I set POST api endpoints for create transaction
    When I send POST HTTP Request for create transaction
    Then I receive valid HTTP response code 200

  @invalid-post-transactions
  Scenario Outline: Invalid Create Transactions
    Given I set POST api endpoints for create transaction
    When I send POST HTTP Request in "<productid>", "<quantity>" in body for invalid create transaction
    Then I receive valid HTTP <codestatus> response code for invalid transaction
    Examples:
    | productid | quantity  | codestatus  |
    | 1         | 2         | 400         |
    | asd       | sdf2      | 400         |
