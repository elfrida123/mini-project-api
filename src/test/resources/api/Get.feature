Feature: Get

  @get-all-categories
  Scenario: Get All Categories
    Given I set GET api endpoints
    When I send GET HTTP Request
    Then I receive valid HTTP response code 200

  @get-category-by-id
  Scenario: Get Category by ID
    Given I set GET api endpoints for get category by id
    When I send GET HTTP Request by id
    Then I receive valid HTTP response code 200

  @invalid-get-category-by-id
  Scenario Outline: Get Category by ID invalid
    Given I set GET api "<endpoints>" endpoints for get category by invalid id
    When I send GET HTTP Request by invalid id
    Then I receive valid HTTP <responsecode> response code
    Examples:
    | endpoints                                  | responsecode |
    | https://be-qa.alta.id/api/categories/asd     | 400          |
    | https://be-qa.alta.id/api/categories/1aku    | 400          |
    | https://be-qa.alta.id/api/categories/1a#     | 400          |
    | https://be-qa.alta.id/api/categories/-19     | 500          |

  @get-all-products
  Scenario: Get All Products
    Given I set GET api endpoints for products
    When I send GET HTTP Request for products
    Then I receive valid HTTP response code 200

  @get-products-by-id
  Scenario: Get Products By Id
    Given I set GET api endpoints for products by id
    When I send GET HTTP Request for products by id
    Then I receive valid HTTP response code 200

  @get-products-by-invalid-id
  Scenario Outline: Get Products By Invalid Id
    Given I set GET api "<endpointsforproduct>" for products by invalid id
    When I send GET HTTP Request for products by invalid id
    Then I receive valid HTTP <statuscode> response code for products by invalid id
    Examples:
    | endpointsforproduct                      | statuscode          |
    | https://be-qa.alta.id/api/products/asd   | 400                 |
    | https://be-qa.alta.id/api/products/1aku  | 400                 |
    | https://be-qa.alta.id/api/products/1a#   | 400                 |
    | https://be-qa.alta.id/api/product/-19    | 404                 |
