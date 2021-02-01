@Task
Feature: Validate dates tasks

  Background:
    Given I log in Salesforce with valid User credentials

  @createContact @deleteContact
  Scenario: I validate the task information
    Given I created a valid campaign
    When I navigate to Contacts page
    And I search for the created contact
    And I create a task with the following data
      | Subject         | Call                    |
      | Expiration date | TOMORROW                |
      | Related with    | Campaigns               |
      | Related value   | Campaing created by API |
      | Status          | In Progress             |
    Then The task should be displayed on Tasks page
    And The task's information should match

  @createContact @deleteContact
  Scenario: I validate the task information
    Given I created a valid opportunity
    When I navigate to Contacts page
    And I search for the created contact
    And I create a task with the following data
      | Subject         | Call                     |
      | Expiration date | TOMORROW                 |
      | Related with    | Opportunities            |
      | Related value   | Opportunity-createdByAPI |
      | Status          | In Progress              |
    Then The task should be displayed on Tasks page
    And The task's information should match

