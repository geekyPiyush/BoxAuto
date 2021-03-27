@functional @collections
Feature: BOX | UI | User dashboard collections CRUD operations

  # Positive
  Scenario: User should be able to create,rename and delete a collection
    Given I go to box cloud application
    And I click on Login button
    And I enter user credentials to login to account
    Then I verify user is logged in to system
    When I create a new collection
    Then I verify added/updated collection visible in nav list
    And  I rename an existing collection
    Then I verify added/updated collection visible in nav list
    When I delete an added collection
    Then I verify collection deleted from nav
    And I click on Logout button
    And I verify user is logged out of system

  Scenario: User should be able to add a folder to an existing collection
    Given I go to box cloud application
    And I click on Login button
    And I enter user credentials to login to account
    Then I verify user is logged in to system
    When I create a new collection
    Then I verify added/updated collection visible in nav list
    And I go to All Files
    And I create a new folder
    And I should see created/updated folder listed in table list
    When I open the new folder
    Then I add folder to an existing collection
    And I verify folder added to collection
    When I click on Logout button
    Then I verify user is logged out of system
