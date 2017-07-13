Feature: Login

  Scenario: User Login
    Given Facebook.com is open
    When User logs in with email "rahullodha0305@gmail.com" and password "test123456"
    Then User should be logged in successfully

  Scenario Outline:
    Given Facebook.com is open
    When User logs in with email "<email>" and password "<password>"
    Then User should be logged in successfully
    #second test will fail due to invalid credentials and facebook invalid credentials page timing out
    Examples:
      | email                    | password   |
      | rahullodha0305@gmail.com | test123456 |
      | test@test.com            | test123    |

  Scenario:
    Given Facebook.com is open
    When User logs in with email and password
      | rahullodha0305@gmail.com | test123456 |
    Then User should be logged in successfully
