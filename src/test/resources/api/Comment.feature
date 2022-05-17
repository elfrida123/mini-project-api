Feature: Comment

  @get-product-comment
  Scenario: Get Product's Comment
    Given I set GET api endpoints for comment
    When I send GET HTTP Request for comment
    Then I receive valid HTTP response code 200

  @give-comment
  Scenario: Write Comment to a Product
    Given I set POST api endpoints for comment
    When I send POST HTTP Request for comment
    Then I receive valid HTTP response code 200

  @invalid-give-comment
  Scenario Outline: Invalid Write Comment to a Product
    Given I set POST api endpoints for comment
    When I send POST HTTP Request in <content> body for invalid give comment
    Then I receive valid HTTP <statusresponse> response code for invalid give comment
    Examples:
    | content    | statusresponse  |
    | 1234       | 500             |