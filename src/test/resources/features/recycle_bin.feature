Feature: recycle bin

  Background:
    Given I log in Salesforce with valid User credentials

  @createContact @cleanRecycleBin
  Scenario: Verify that the information of the deleted Contact matches the history of items deleted in the recycle bin page
    When I navigate to Contacts page
    And I search the Test Contact on Contacts page
    And I delete the Test Contact on Contacts page
    And I navigate to Recycle Bin page
    Then the deleted Contact should be displayed on Recycle bin page
    And the contact information should match with the contact information on table of Recycle bin page
