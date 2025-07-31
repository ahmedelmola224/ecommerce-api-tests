Feature: User Authentication
  As an e-commerce user
  Want to authenticate with the system
  To access protected resources

  @regression
  Scenario Outline: Successful login with valid credentials
    Given  username "<useremail>" and password "<password>"
    When sending "POST" request to "LoginAPI" with credentials
    Then response status code should be 200
    And response should contain "token"
    And response should contain "userId"
    And response "message" should contain "Login Successfully"

    Examples:
      | useremail                     | password      |
      | ahmedelmola224@gmail.com      | 123456@Ahmed  |

    @regression
Scenario: Unsuccessful login with invalid username
  Given  username "wronguser" and password "123456@Ahmed "
  When sending "POST" request to "LoginAPI" with credentials
  Then response status code should be 400
  And response "message" should contain "Incorrect email or password."

      @regression
  Scenario: Unsuccessful login with invalid password
    Given  username "ahmedelmola224@gmail.com " and password "wrongpass"
    When sending "POST" request to "LoginAPI" with credentials
    Then response status code should be 400
    And response "message" should contain "Incorrect email or password."