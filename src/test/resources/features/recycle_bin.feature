Feature: recycle bin

  Background:
    Given I log in Sales Force with valid User credentials

  @createContact @cleanRecycleBin
  Scenario Verify that the date of the deleted item matches the history of items deleted in the recycle bin page
    When I navigate to Contacts page
    And I delete the created Contact on Contacts page
    And I navigate to Recycle Bin page
    Then the deleted Contact should be displayed on Recycle bin page
    And the contact deleted date should match with the time of the deleted element
