Feature: recycle bin


  @Functional @createAccount @createContact @deleteAccount @cleanRecycleBin
  Scenario: Verify that the information of the created Contact matches the history of items deleted in the recycle bin page
    Given I log in Salesforce with valid User credentials
    When I navigate to Contacts page
    And I search the Contact on Contacts page
    Then the contact information should match with the contact information on table of Contacts page
    When I select the contact
    And I delete the contact on ContactDetails page
    And I navigate to Recycle Bin page
    Then the deleted Contact should be displayed on Recycle bin page
    And the contact information should match with the contact information on table of Recycle bin page
