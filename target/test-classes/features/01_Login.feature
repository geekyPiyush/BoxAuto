@functional @login
Feature: BOX | UI | Login basic operations

  # Positive
  Scenario: System should login into the account successfully with valid credentials
    Given I go to box cloud application
    And I click on Login button
    And I enter user credentials to login to account
    Then I verify user is logged in to system
    When I click on Logout button
    Then I verify user is logged out of system

   # Negative
  Scenario: System should not login into the account with invalid credentials
    Given I go to box cloud application
    And I click on Login button
    And I enter invalid user credentials to login to account: auto_boxtest@example.com invAlid123#
    Then I verify user gets invalid credential message
