Feature: Login

  Scenario: User Login
    Given Facebook.com is open
    When User logs in with email "rahullodha0305@gmail.com" and password "test123456"
    Then User should be logged in successfully
