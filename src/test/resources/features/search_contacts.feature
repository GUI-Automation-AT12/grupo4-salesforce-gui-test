Feature: Search contacts

  Background:
    Given I log in Salesforce with valid User credentials
    @createContact @deleteContact
    Scenario: I search for the more recent created contact
      When I navigate to Contacts page
      And I search for the created contact
      Then the searched contact should be displayed on contacts page
      And I validate the information of the searched contact