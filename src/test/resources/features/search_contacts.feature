@Task
Feature: Validate dates of a created task

  Background:
    Given I log in Salesforce with valid User credentials

    @createContact @deleteContact @setup
    Scenario: I validate the task information
      Given I created a valid campaign
      When I navigate to Contacts page
      And I search for the created contact
      And I create a task with the following data
      |   Subject                     |    Call            |
      |   Expiration date             |    TOMORROW        |
      |   Related with                |    Activos         |
      |   Related value               |    Campaña prueba  |
      |   Status                      |    In Progress     |
      Then The task should be displayed on Tasks page
      And The task's information should match
