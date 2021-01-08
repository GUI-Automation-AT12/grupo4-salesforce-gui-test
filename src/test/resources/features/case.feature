Feature: Create a case

  Background: I log in to Salesforce with Editable user credentials

  @createContact @createCampaign @deleteContact @DeleteCampaign @deleteEvent
  Scenario: Create a case
    When I navigate to Case page
    And I create the case with the following information
      | Contact Name | Contact test |
      | Account Name | Account test |
      | Status       | New          |
      | Subject      | New Case     |
      | Description  | Description  |
    Then "Case was created" message should be displayed My Cases section
    And the case information should be displayed in My Cases section table