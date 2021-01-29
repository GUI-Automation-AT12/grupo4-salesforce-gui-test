@Campaign
Feature: Campaign

  Background:
    Given I log in Salesforce with valid User credentials

  @createLeads @deletedLeads
  Scenario: Create Campaign Testing and become members to Lead 1 and Lead 2
    When I navigate to Campaigns page
    And I create the Testing Campaign with the following information
      | Name      | Campaign Testing |
      | Type      | Conference       |
      | Status    | In Progress      |
      | StartDate | TODAY            |
      | EndDate   | TOMORROW         |
    Then the campaign information should be displayed in Campaign Details page
    When I navigate to Manage Members page of Campaign Test
    And I search for Lead 1 by with the following information
      | Firstname | Jhon Luna |
      | Lastname  | Apellido  |
    And I select the Lead 1
    Then The Lead 1 information should be displayed in Existing Members section
    When I search for Lead 2 by with the following information
      | Firstname | Jhon Luna |
      | Lastname  | Apellido  |
    And I select the Lead 2
    Then The Lead 2 information should be displayed in Existing Members section
