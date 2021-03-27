@functional @folder
Feature: BOX | UI | User dashboard folder CRUD operations

  # Positive
  @createfolder
  Scenario: User should be able to create a new folder
    Given I go to box cloud application
    And I click on Login button
    And I enter user credentials to login to account
    Then I verify user is logged in to system
    When I create a new folder
    Then I should see created/updated folder listed in table list
    And I click on Logout button
    And I verify user is logged out of system

  # Positive
  @renameFolder
  Scenario: User should be able to rename an existing folder
    Given I go to box cloud application
    And I click on Login button
    And I enter user credentials to login to account
    Then I verify user is logged in to system
    When I create a new folder
    Then I should see created/updated folder listed in table list
    When I rename an existing folder
    Then I should see created/updated folder listed in table list
    And I click on Logout button
    And I verify user is logged out of system

  # Positive
  @deleteFolder
  Scenario: User should be able to delete an existing folder
    Given I go to box cloud application
    And I click on Login button
    And I enter user credentials to login to account
    Then I verify user is logged in to system
    When I create a new folder
    Then I should see created/updated folder listed in table list
    When I delete an existing folder
    Then I should see folder deleted from table list
    And I click on Logout button
    And I verify user is logged out of system