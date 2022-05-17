Feature: Ratings

  @get-product-ratings
  Scenario: Get Product’s Ratings
    Given I set GET api endpoints for get ratings
    When I send GET HTTP Request for get ratings
    Then I receive valid HTTP response code 200

  @give-products-ratings
  Scenario: Give Ratings to a Product
    Given I set POST api endpoints for give ratings
    When I send POST HTTP Request for give ratings
    Then I receive valid HTTP response code 200

  @invalid-give-products-ratings
  Scenario Outline: Invalid Give Ratings to a Product
    Given I set POST api endpoints for give ratings
    When I send POST HTTP Request in "<count>" body for invalid give ratings
    Then I receive valid HTTP <responsestatus> response code for invalid give ratings
    Examples:
    | count | responsestatus  |
    | 2     | 200             |