@Event
Feature: Event

  Background:
    Given I log in Salesforce with valid User credentials

  @createContact @createProduct @deletedProduct @deleteContact @deletedEvent
  Scenario: Create a events with a contact related to a Product in Calendar Page
    When I navigate to Calendar page
    And I create the event with the following information
      | Subject          | Call                      |
      | Location         | Bolivia                   |
      | StartDate        | TODAY                     |
      | StartTime        | NOW                       |
      | EndDate          | TOMORROW                  |
      | EndTime          | NOW                       |
      | Select Name      | Contact                   |
      | Name             | Jhon Smith created By API |
      | Select RelatedTo | Product                   |
      | RelatedTo        | Product A                 |
    Then the event information should be displayed in Calendar section table
    And the event information should be displayed in Event Details page
    When I navigate to Contacts page
    And I Select the contact related to event
    Then The event information should be displayed in Contact Details page Activity section