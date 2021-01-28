Feature: Create an event

  Background:
    Given I log in Salesforce with valid User credentials

  @createContact @createCampaign @deleteEvent @deleteContact @deleteCampaign
  Scenario: Create a event with a contact related to a Campaign in Calendar Page
    When I navigate to Calendar page
    And I create the event with the following information
      | Subject   | Call         |
      | StartDate | Today        |
      | StartTime | now          |
      | EndDate   | Today        |
      | EndTime   | later        |
      | Entity    | Contact      |
      | Name      | Contact Test |
      | Entity    | Campaign     |
      | Entity    | Campaign     |
      | Entity    | Campaign     |
      | Entity    | Campaign     |
      | Entity    | Campaign     |
      | Entity    | Campaign     |
      | Entity    | Campaign     |
    Then "Event call was created" message should be displayed in Event Section
    And The event information should be displayed in Event Details section
    And The event information should be displayed in Calendar section table
    When I navigate to Contacts page
    And I Select the contact related to event
    Then The event information should be displayed in Contact Details page Activity section
    When I navigate to Campaign page
    And I Select the campaign related to event
    Then The event information should be displayed in Campaign Details page Activity section
