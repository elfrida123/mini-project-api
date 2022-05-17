Feature: Post

  @create-category
  Scenario: Create category
    Given I set POST api endpoints
    When I send POST HTTP Request
    And I receive valid HTTP response code 200
    Then I receive valid data for new category

  @invalid-create-category
  Scenario Outline: Create category invalid
    Given I set POST api endpoints
    When I send POST HTTP Request in <body> body
    Then I receive valid HTTP <responsecode> response code for create category
    Examples:
    | body          | responsecode  |
    | 123           | 400           |

  @create-product
  Scenario: Create product
    Given I set POST api endpoints for products
    When I send POST HTTP Request for products
    And I receive valid HTTP response code 200
    Then I receive valid data for new product

  @invalid-create-product
  Scenario Outline: Create product invalid
    Given I set POST api endpoints
    When I send POST HTTP Request in <name>, "<price>", "<categories>" body for product
    Then I receive valid HTTP <code> response code for create product
    Examples:
      | name          | price         | categories     | code         |
      | 123           | 2000          | asd            | 400          |