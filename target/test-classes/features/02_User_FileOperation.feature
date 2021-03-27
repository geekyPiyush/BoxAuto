@functional @files
Feature: BOX | UI | User dashboard file CRUD operations

  # Positive
  Scenario: User should be able to upload/rename and delete a new file to dashboard
    Given I go to box cloud application
    And I click on Login button
    And I enter user credentials to login to account
    Then I verify user is logged in to system
    When I upload a new file with jpg extension
    Then I should see uploaded/updated file listed in table list
    When I rename an existing file
    Then I should see uploaded/updated file listed in table list
    When I delete an existing file
    Then I should see file deleted from table list
    And I click on Logout button
    And I verify user is logged out of system

  Scenario: User should be able to upload/delete a new file to/from folder
    Given I go to box cloud application
    And I click on Login button
    And I enter user credentials to login to account
    Then I verify user is logged in to system
    When I create a new folder
    And I should see created/updated folder listed in table list
    And I open the new folder
    When I upload a new file with pdf extension
    Then I should see uploaded file in folder
    And I rename an existing file
    And I delete a file from folder
    Then I should notsee uploaded file in folder
    And I click on Logout button
    And I verify user is logged out of system