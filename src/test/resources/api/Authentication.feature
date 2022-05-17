Feature: Authentication

  @register
  Scenario: Register
    Given I set POST api endpoints for register
    When I send POST HTTP Request for register
    And I receive valid HTTP response code 200
    Then I receive valid data for new account

  @invalid-register
  Scenario Outline: Invalid Register
    Given I set POST api endpoints for register
    When I send POST HTTP Request in "<fullname>", "<email>", "<password>" body
    Then I receive valid HTTP <status> status
    Examples:
      | fullname                              | email                                   | password    | status  |
      | 097361==i                             | elfrida@gmail.com                       | Akucantik   | 400     |
      | Elfrida Tampubolon                    | %gmail.com                              | Akucantik   | 400     |
      | Elfrida Tampubolon                    | elfrida123@gmail.com                    | Akucantik   | 400     |
      | Elfrida                               | elfrida@gmail.comelfrida121@gmail.com   | Akucantik   | 400     |
      | q                                     | @                                       | r           | 400     |
      | elfrida!!88                           | elfrida@gmail.com                       | elfrida$$12 | 400     |
      | ELfRidA                               | elfrida@gmail.com                       | HgaklsOPH   | 400     |

  @login
  Scenario: Login
    Given I set POST api endpoints for login
    When I send POST HTTP Request for login
    Then I receive valid HTTP response code 200

  @invalid-login
  Scenario Outline: Invalid Login
    Given I set POST api endpoints for login
    When I send POST HTTP Request in "<email>", "<password>" body
    Then I receive valid HTTP <coderesponse> response code for invalid login
    Examples:
      | email             | password     | coderesponse |
      | elfrida@gmail.com | Aku          | 400          |
      | elfrida@.com      | Akucantik88@ | 400          |
      | elfrida@gmail.com |              | 400          |
      | elfrida@.com      |              | 400          |
      |                   | Akucantik88@ | 400          |
      |                   | Aku          | 400          |