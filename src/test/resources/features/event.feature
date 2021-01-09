Feature: Create an event

  Background:
    Given I log in to Salesforce with valid user credentials

  @createContact @createCampaign @deleteContact @DeleteCampaign @deleteEvent
  Scenario: Create a event with a contact related to a Campaign in Calendar Page
    When I navigate to Calendar page
    And I create the event with the following information
      | Subject    | Call           |
      | Start Date | Today          |
      | Start Time | now            |
      | End Date   | Today          |
      | End Time   | later          |
      | Entity     | Contact        |
      | Name       | Contact Test   |
      | Entity     | Campaign       |
      | Related to | Campaign Test  |
    Then "Event call was created" message should be displayed in Event Section
    And The information should be displayed in Event Details section
    And The information should be displayed in Calendar section table
    And The information should be match with information in Calendar section table
